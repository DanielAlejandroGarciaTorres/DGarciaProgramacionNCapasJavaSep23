/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author ALIEN 34
 */

@Controller
public class LoginController {
    
    @GetMapping("/")
    public String Login(Model model,HttpSession session){
        Alum alumno = new Alum();
        alumno.setEstatus("Y");
        alumno.setNombre("Kevin");
        session.setAttribute("Username", "Joserbp");
        session.setAttribute("Alumno", alumno);
        return "Login";
    }
    @PostMapping("/")
    public String Login(@RequestBody() Alum alumnoIngresado){
        //Alumn alumnoLogin = GetByEmail(alumnoIngresado.Email)
        //if (existAlum)
            //label Datos incorrectos
            // return "Login"
        //else
            //Match contraseña
            //if(match)
                //return "Listado"
            //else
                //label Datos incorrectos
                // return "Login"
                return "Login";
    }
        
   
}
