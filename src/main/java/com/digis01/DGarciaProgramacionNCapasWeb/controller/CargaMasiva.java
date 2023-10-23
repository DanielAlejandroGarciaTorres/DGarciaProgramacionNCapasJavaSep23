/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.Entity.ResultExcel;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String CargaMasiva(){
        
        return "CargaMasiva";
    }
    
    @PostMapping("/CargaMasiva/txt")
    public String CargaMasivaTxt(@RequestParam MultipartFile archivoTxt) {
        
        return "CargaMasiva";
    }

    @PostMapping("/CargaMasiva/excel")
    public String CargaMasiva(Model model,@RequestParam("archivo") MultipartFile archivo, HttpSession session) throws IOException {

        if (archivo != null && !archivo.isEmpty()) {
            String extension = StringUtils.getFilenameExtension(archivo.getOriginalFilename());
            if (extension.equals("xlsx")) {
                List<Alum> alumnos = LeerArchivo(archivo);
                String root = System.getProperty("user.dir");
                String path = "src/main/resources/static/archivos/";
                String fileName = archivo.getOriginalFilename(); 
                String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
                String absolutePath = root + "/" + path + fecha +fileName;
                archivo.transferTo(new File(absolutePath));
                if(!alumnos.isEmpty()){
                    ResultExcel result = Validar(alumnos);
                    if(!result.getErrores().isEmpty()){
                        model.addAttribute("errores", result.getErrores());
                        return "CargaMasiva";
                    }
                    else{
                        session.setAttribute("path", absolutePath);
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
    
    @PostMapping("/CargaMasiva/AddBD")  //EL BTN NUEVO ( SOLO SE VE CUANDO EL ARCHIVO ESTA COMPLETO)
    public String AddBaseDatos(HttpSession session){
        String path = session.getAttribute("path").toString();
        
//        List<Alum> alumnos = LeerArchivo(archivo); //Modificar para poder usar el path
//        for(Alum alumno : alumnos){
//            //DAO ADD (alumno)
//        }
        return "CargaMasiva";  //MOSTRAR AL USUARIO UNA LEYENDA DATOS CARGADOS EN LA BD
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
        workbook.close();
        return alumnos;
    }
}
