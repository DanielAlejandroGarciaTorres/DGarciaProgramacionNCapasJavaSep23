/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.restController;

import com.digis01.DGarciaProgramacionNCapasWeb.DAO.AlumnoDAOImplementation;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ALIEN 34
 */
@RestController
@RequestMapping("/alumnoApi")
public class AlumnoRestController {
    
    private AlumnoDAOImplementation alumnoDAOImplementation;

    public AlumnoRestController(AlumnoDAOImplementation alumnoDAOImplementation) {
        this.alumnoDAOImplementation = alumnoDAOImplementation;
    }

    @GetMapping("/GetAll")
    public List<Alum> GetALL(){
        return alumnoDAOImplementation.GetAll(new Alum("", "", ""));
    }
    
    
    
    
}
