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
public class AlumnoDAOImplementation implements IAlumnoDAO {

    private EntityManager entityManager; // referencia / conexión / persistencia  

    @Autowired //Inyección de dependencias.
    public AlumnoDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Alum> GetAll(Alum alumno) {

        // entityManager - Peresistencia 
        TypedQuery<Alum> query = entityManager.createQuery("FROM Alum WHERE "
                + "LOWER(nombre) LIKE LOWER(:nombrealumno) AND "
                + "LOWER(apellidopaterno) LIKE LOWER(:apellidopaternoalumno) AND "
                + "LOWER(apellidomaterno) LIKE LOWER(:apelldiomaeternoalumno)", Alum.class);

        query.setParameter("nombrealumno", ("%" + alumno.getNombre() + "%"));
        query.setParameter("apellidopaternoalumno", ("%" + alumno.getApellidopaterno() + "%"));
        query.setParameter("apelldiomaeternoalumno", ("%" + alumno.getApellidomaterno() + "%"));

        List<Alum> alumnos = query.getResultList();  // la tabla
        // objeto - registros - recurso 

        return alumnos;
    }

    @Override
    @Transactional
    public int Add(Alum alumno) {//
//        alumno.setFechanacimiento(new Date());
        Semestre semestre = new Semestre();
        semestre.setIdsemestre(1);
        alumno.setSemestre(semestre);
        entityManager.persist(alumno);

        return alumno.getIdalumno();
//        Alum alumMuestra = alumno;
//        alumMuestra.getNombre();
    }

    @Override
    @Transactional
    public void ChangeStatus(int idAlumno, boolean status) {
        Alum alumno = entityManager.find(Alum.class, idAlumno);
//        if (status) {
//            alumno.setStatus("Y");
//        } else {
//            alumno.setStatus("N");
//        }
//        
        String statusString = (status)?  "Y" : "N"; //Operador Ternario
        alumno.setEstatus(statusString);
        
        //alumno.setStatus((status)?  "Y" : "N"); //CORRECTO
        entityManager.merge(alumno);
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
