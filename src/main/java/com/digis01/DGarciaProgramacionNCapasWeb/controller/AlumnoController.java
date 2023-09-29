/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.DAO.DireccionDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.DAO.EstadoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.DAO.SemestreDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.AlumnoDireccion;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Direccion;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Estado;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Semestre;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ALIEN 34
 */
//localhost:8080/alumno/
@Controller
@RequestMapping("/alumno")
public class AlumnoController {

    private AlumnoDAOImplementation alumnoDAOImplementation;
    private DireccionDAOImplementation direccionDAOImplementation;
    private SemestreDAOImplementation semestreDAOImplementation;
    private EstadoDAOImplementation estadoDAOImplementation;

    @Autowired // inyeccion
    public AlumnoController(AlumnoDAOImplementation alumnoDAOImplementation,
                            DireccionDAOImplementation direccionDAOImplementation,
                            SemestreDAOImplementation semestreDAOImplementation,
                            EstadoDAOImplementation estadoDAOImplementation) {
        this.alumnoDAOImplementation = alumnoDAOImplementation;
        this.direccionDAOImplementation = direccionDAOImplementation;
        this.semestreDAOImplementation = semestreDAOImplementation;
        this.estadoDAOImplementation = estadoDAOImplementation;
    }

    //localhost:8080/alumno/listado
    @GetMapping("/listado")
    private String listadoAlumnos(Model model) {
        List<Alum> alumnos = alumnoDAOImplementation.GetAll(); // recuperación de datos
        model.addAttribute("alumnos", alumnos); //envío de datos para HTML
        model.addAttribute("alumno", new Alum());
        
        //List<Direccion> direcciones = direccionDAOImplementation.GetAll();
       
        return "listadoAlumnos";
    }


    //localhost:8080/alumno/editarAlumno/85
    @GetMapping("/form/{idalumno}")
    public String Form(@PathVariable int idalumno, Model model) {
//        List<Semestre> semestres = semestreDAOImplementation.GetAll();
//        model.addAttribute("semestres", semestres);
        model.addAttribute("semestres", semestreDAOImplementation.GetAll());
        model.addAttribute("estados", estadoDAOImplementation.GetAll());
        
        if (idalumno == 0) { //ADD
            model.addAttribute("alumnodireccion", new AlumnoDireccion());
            return "formAlumnoEditable";
        } else { //UPDATE
            Alum alumno = alumnoDAOImplementation.GetById(idalumno);
            model.addAttribute("alumno", alumno);
            return "formAlumnoEditable";
        }
    }

    
      // VALIDACIÓN CON INFORMACIÓN DEL CLIENTE
    
//    @PostMapping("/form")
//    public String Update(@ModelAttribute AlumnoDireccion alumnodireccion) {
//        // actualización
//        Semestre semestre = new Semestre();
//        semestre.setIdsemestre(2);
//        alumnodireccion.getAlumno().setSemestre(semestre);
//
//        if (alumnodireccion.getAlumno().getIdalumno() > 0) { //UPDATE
//            alumnoDAOImplementation.Update(alumnodireccion.getAlumno());
//        } else {
//            int idAlumno = alumnoDAOImplementation.Add(alumnodireccion.getAlumno()); //Regresar el IDINSERTADO
//            //alumnoDireccion.direccion.IdAlumno = 0; //Al idinsertado
//            //NOTAAAAAAA: esto es por que no recuperamos información de dirección
//            Direccion direccion = new Direccion("Reforma", "09", "199", new Estado(1), new Alum(idAlumno));
//            alumnodireccion.setDireccion(direccion); 
//            direccionDAOImplementation.Add(alumnodireccion.getDireccion());
//        }
//
//        return "redirect:/alumno/listado";
//    }
    
    
    // VALIDACIÓN CON CLIENTE Y SERVIDOR
    @PostMapping("/form")
    public String Update(@Valid @ModelAttribute("alumnodireccion") AlumnoDireccion alumnodireccion, BindingResult bindingResult, Model model ) {
        // actualización
        
        
        if (bindingResult.hasErrors()){
            
            model.addAttribute("alumnodireccion", alumnodireccion);
            return "formAlumnoEditable";
        }
//        
//        Semestre semestre = new Semestre();
//        semestre.setIdsemestre(2);
//        alumnodireccion.getAlumno().setSemestre(semestre);
//
        if (alumnodireccion.getAlumno().getIdalumno() > 0) { //UPDATE
            alumnoDAOImplementation.Update(alumnodireccion.getAlumno());
        } else {
            int idAlumno = alumnoDAOImplementation.Add(alumnodireccion.getAlumno()); //Regresar el IDINSERTADO
            //alumnoDireccion.direccion.IdAlumno = 0; //Al idinsertado
            //NOTAAAAAAA: esto es por que no recuperamos información de dirección
            Direccion direccion = new Direccion("Reforma", "09", "199", new Estado(1), new Alum(idAlumno));
            alumnodireccion.setDireccion(direccion); 
            direccionDAOImplementation.Add(alumnodireccion.getDireccion());
        }

        return "redirect:/alumno/listado";
    }

    //    @GetMapping("/add")
//    public String Add(Model model) {
//
//        // Alum alumno = new Alum();
//        model.addAttribute("alumno", new Alum());
//        return "formAlumno";
//    }
    
//        @PostMapping("addalumno")
//    public String Add(@ModelAttribute Alum alumno) {
//
//        //la logica necesaria para enviar dicha información a DAO
//        alumnoDAOImplementation.Add(alumno);
//
//        return "redirect:/alumno/listado";
//
//    }

}
