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
import org.springframework.transaction.annotation.Transactional;

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
    
    public Direccion GetByIdUsuario(int idAlumno){
        TypedQuery<Direccion> query = entityManager.createQuery("FROM Direccion WHERE alumno.idalumno=:idAlumno", Direccion.class);
        query.setParameter("idAlumno", idAlumno);
        Direccion direccion;
        try{
            direccion = query.getSingleResult();
        } catch (Exception ex){
            direccion = new Direccion();
        }
        return direccion;
    }
    
    
    /*  */

    @Override
    @Transactional
    public void Add(Direccion direccion) {
        entityManager.persist(direccion);
    }
}
