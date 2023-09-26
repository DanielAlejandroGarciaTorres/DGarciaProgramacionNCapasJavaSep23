/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Semestre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    
    @GetMapping("/add")
    public String Add(Model model){
        
        // Alum alumno = new Alum();
        model.addAttribute("alumno", new Alum());
        return "formAlumno";
    }
    
    @PostMapping("addalumno")
    public String Add(@ModelAttribute Alum alumno){
        
        //la logica necesaria para enviar dicha información a DAO
        alumnoDAOImplementation.Add(alumno);
        
        return "redirect:/alumno/listado";
        
    }
    //localhost:8080/alumno/editarAlumno/85
    @GetMapping("/editarAlumno/{idalumno}")
    public String Update(@PathVariable int idalumno, Model model){
        
        //getByID --> precargar elforumalrio JPQL
        Alum alumno = alumnoDAOImplementation.GetById(idalumno);
        
        model.addAttribute("alumno", alumno);

        
        // precargarlo con el model 
        
        return "formAlumnoEditable";
    }
    
    @PostMapping("/updateAlumno")
    public String Update(@ModelAttribute Alum alumno){
        // actualización
        Semestre semestre = new Semestre();
        semestre.setIdsemestre(2);
        alumno.setSemestre(semestre);
        alumnoDAOImplementation.Update(alumno);
        
        return "redirect:/alumno/listado";
    }
    
    
    
}



    

