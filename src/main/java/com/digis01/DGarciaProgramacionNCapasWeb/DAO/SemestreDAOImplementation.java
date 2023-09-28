/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.DAO;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Semestre;
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
public class SemestreDAOImplementation implements ISemestreDAO{

    private EntityManager entityManager;

    @Autowired // inyección
    public SemestreDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    @Override
    public List<Semestre> GetAll() {
        TypedQuery<Semestre> query = entityManager.createQuery("FROM Semestre", Semestre.class);
        List<Semestre> semestres = query.getResultList();
        return semestres;
    }
    
}
