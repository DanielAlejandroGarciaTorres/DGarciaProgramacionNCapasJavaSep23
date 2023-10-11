/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.service;

import com.digis01.DGarciaProgramacionNCapasWeb.Entity.NumerosOperacion;
import com.digis01.DGarciaProgramacionNCapasWeb.Entity.Resultado;


/**
 *
 * @author ALIEN 34
 */
public interface IDemoServicio {
    
    String Saludo(String nombre);
    
    Resultado Suma(NumerosOperacion numerosOperacion);
}
