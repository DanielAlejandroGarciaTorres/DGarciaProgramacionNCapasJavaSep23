/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired 
    public AlumnoController(AlumnoDAOImplementation alumnoDAOImplementation) {
        this.alumnoDAOImplementation = alumnoDAOImplementation;
    }
    
    //localhost:8080/alumno/listado
    @GetMapping("/listado")
    private String listadoAlumnos(Model model){
        List<Alum> alumnos = alumnoDAOImplementation.GetAll(); // recuperación de datos
        model.addAttribute("alumnos",alumnos); //envío de datos para HTML
        return "listadoAlumnos";
        
    }
    
}



    

