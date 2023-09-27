/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.DAO;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Direccion;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ALIEN 34
 */
@Repository
public class DireccionDAOImplementation implements IDireccionDAO{
    
    private EntityManager entityManager;

    @Autowired // inyección
    public DireccionDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    
    public List<Direccion> GetAll(){
        
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion", Direccion.class);
        List<Direccion> direcciones = query.getResultList();
        
        return direcciones;
    }
    
    /*  */
}
