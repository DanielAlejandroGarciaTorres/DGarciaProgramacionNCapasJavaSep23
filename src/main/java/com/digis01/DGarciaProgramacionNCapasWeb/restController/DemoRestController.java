/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.restController;

import com.digis01.DGarciaProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.DGarciaProgramacionNCapasWeb.Entity.Resultado;
import com.digis01.DGarciaProgramacionNCapasWeb.service.DemoServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ALIEN 34
 */
@RestController
@RequestMapping("/api")
public class DemoRestController {
    
    @PostMapping("/suma")
    public Resultado suma(@RequestBody NumerosOperacion numeros) {
        DemoServiceImplementation demoServiceImplementation = new DemoServiceImplementation();
        return demoServiceImplementation.Suma(numeros);
    }
    
}
