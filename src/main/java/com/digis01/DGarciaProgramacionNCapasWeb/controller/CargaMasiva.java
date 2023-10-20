/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    
    @PostMapping("/CargaMasiva/excel")
    public String CargaMasivaExel(@RequestParam MultipartFile archivoExcel) {
        
        return "CargaMasiva";
    }
    @PostMapping("/CargaMasiva/txt")
    public String CargaMasivaTxt(@RequestParam MultipartFile archivoTxt) {
        
        return "CargaMasiva";
    }
}
