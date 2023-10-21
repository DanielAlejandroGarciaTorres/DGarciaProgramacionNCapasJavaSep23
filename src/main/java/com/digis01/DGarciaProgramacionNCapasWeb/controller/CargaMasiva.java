/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.Entity.ResultExcel;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.ui.Model;

/**
 *
 * @author ALIEN 61
 */
@Controller
public class CargaMasiva {

    @GetMapping("/CargaMasiva")
    public String CargaMasiva() {
        return "CargaMasiva";
    }

    @PostMapping("/CargaMasiva")
    public String CargaMasiva(Model model,@RequestParam("archivo") MultipartFile archivo) throws IOException {

        if (archivo != null && !archivo.isEmpty()) {
            String extension = StringUtils.getFilenameExtension(archivo.getOriginalFilename());
            if (extension.equals("xlsx")) {
                List<Alum> alumnos = LeerArchivo(archivo);
                if(alumnos.size() > 0){
                    ResultExcel result = Validar(alumnos);
                    if(result.getErrores().size() > 0){
                        model.addAttribute("errores", result.getErrores());
                        return "CargaMasiva";
                    }
                }else{
                    //Validaciones
                }
            } else {
                // Validaciones
            }
        } else {
            //Validaciones
        }
        return "View";
    }

    public ResultExcel Validar(List<Alum> alumnos){
        
        ResultExcel resultPrincipal = new ResultExcel();
        
        resultPrincipal.setErrores(new ArrayList());
        int fila = 1;
        String errorMessage = "";
        
        for(Alum alumno : alumnos){
            if(alumno.getNombre().equals("")){
                //errorMessage = errorMessage + ""; lo mismo pero mas caro
                errorMessage += "Falto Nombre";
            }
            if(alumno.getApellidopaterno().equals("")){
                errorMessage += "Falto Apellido Paterno";
            }
            
            errorMessage += (alumno.getApellidomaterno().equals(""))? "Falto Apellido Materno" : "";
           
            if(!errorMessage.equals("")){ //Hubo un error
                ResultExcel resultExcel = new ResultExcel();
                resultExcel.setRow(fila);
                resultExcel.setErrorMessage(errorMessage);
                
                resultPrincipal.getErrores().add(resultExcel);
                errorMessage = "";
            }
            
            fila ++;
            //fila = fila + 1; lo mismo que arriba
        }
        return resultPrincipal;
    }
    public List<Alum> LeerArchivo(MultipartFile archivo) throws IOException {

        List<Alum> alumnos = new ArrayList<Alum>();
        XSSFWorkbook workbook = new XSSFWorkbook(archivo.getInputStream());
        Sheet worksheet = workbook.getSheetAt(0);

        //Ignorar la primera fila (row)
        for (Row row : worksheet) {
            Alum alumno = new Alum();
            alumno.setNombre(row.getCell(0).toString());
            alumno.setApellidopaterno(row.getCell(1).toString());
            alumno.setApellidomaterno(row.getCell(2).toString());
            
            alumnos.add(alumno);
            
        }
        return alumnos;
    }
}