/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.JPA;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.format.annotation.DateTimeFormat;


/**
 *
 * @author ALIEN 34
 */
@Entity
public class Alum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idalumno;

    @NotEmpty(message = "Ingresa datos")
    @Size(min = 3, max = 5, message = "Cadena entre 3 y 5")
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;

    @ManyToOne  // --> muchos alumnos tienen un mismo semestre 
    @JoinColumn(name = "idsemestre") // columna con la llave foranea
    private Semestre semestre;
    
    @Lob
    private String imagen;

    private String estatus;
    
    public Alum() {
    }

    public Alum(int idalumno) {
        this.idalumno = idalumno;
    }

    public Alum(String nombre, String apellidopaterno, String apellidomaterno) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
    }
    
    

    public Alum(String nombre, String apellidopaterno, String apellidomaterno, Date fechanacimiento) {
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.fechanacimiento = fechanacimiento;
    }

    public Alum(int idalumno, String nombre, String apellidopaterno, String apellidomaterno, Date fechanacimiento) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.fechanacimiento = fechanacimiento;
    }

    public Alum(int idalumno, String nombre, String apellidopaterno, String apellidomaterno, Date fechanacimiento, Semestre semestre) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.fechanacimiento = fechanacimiento;
        this.semestre = semestre;
    }
    
    

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    // ${alumno.fechanacimiento}
    public Date getFechanacimiento() {
        return fechanacimiento;
    }
    // *{alumno.fechanacimiento}

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
    
    
//    public void setFechanacimiento(String fechanacimiento) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
//        try {
//            this.fechanacimiento = simpleDateFormat.parse(fechanacimiento);
//        } catch (ParseException ex) {
//            Logger.getLogger(Alum.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    
    
    
}
