/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.DAO;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import java.util.List;

/**
 *
 * @author ALIEN 34
 */
// Contrato 
public interface IAlumnoDAO {
    
    //firma de metodo 
    // tipo de retorno, nombre del método, parámetros
    List<Alum> GetAll(Alum alumno);
    
    int Add(Alum alumno);
    
//    void Update(int id, Alum alumno);
    
    Alum GetById(int idalumnoeditable);
    
    void Update(Alum alumno);
    
    void ChangeStatus(int idAlumno, boolean status);
}
