/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
