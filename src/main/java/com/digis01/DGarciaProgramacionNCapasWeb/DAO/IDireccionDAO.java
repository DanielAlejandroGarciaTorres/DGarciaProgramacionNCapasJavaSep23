/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.DAO;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Direccion;
import java.util.List;

/**
 *
 * @author ALIEN 34
 */
public interface IDireccionDAO {
    
    List<Direccion> GetAll();
    
    void Add(Direccion direccion);
    
    Direccion GetByIdUsuario(int IdUsuario);

}
