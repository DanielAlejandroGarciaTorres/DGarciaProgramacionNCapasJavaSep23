/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.DAO;

import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Alum;
import com.digis01.DGarciaProgramacionNCapasWeb.JPA.Semestre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ALIEN 34
 */
@Repository
public class AlumnoDAOImplementation implements IAlumnoDAO{

    private EntityManager entityManager;

    @Autowired //Inyección de dependencias.
    public AlumnoDAOImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Alum> GetAll() {
        
        TypedQuery<Alum> query = entityManager.createQuery("FROM Alum", Alum.class);
        List<Alum> alumnos = query.getResultList();
        
        return alumnos;
    }

    @Override
    @Transactional
    public void Add(Alum alumno) {
//        alumno.setFechanacimiento(new Date());
        Semestre semestre = new Semestre();
        semestre.setIdsemestre(1);
        alumno.setSemestre(semestre);
        entityManager.persist(alumno);
    }

    @Override
    public Alum GetById(int idalumnoeditable) {
        //JPQL
        TypedQuery<Alum> query = entityManager.createQuery("FROM Alum WHERE idalumno=:idalumnoeditable", Alum.class);
        query.setParameter("idalumnoeditable", idalumnoeditable);
           
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void Update(Alum alumno) {
        entityManager.merge(alumno);
    }
    
    
    
    

    
}
