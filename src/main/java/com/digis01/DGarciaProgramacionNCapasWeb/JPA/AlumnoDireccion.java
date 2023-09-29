/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.JPA;

import jakarta.validation.Valid;

/**
 *
 * @author ALIEN 34
 */
public class AlumnoDireccion {

    @Valid
    private Alum alumno;
    @Valid
    private Direccion direccion;

    public AlumnoDireccion() {

    }

    public AlumnoDireccion(Alum alumno, Direccion direccion) {
        this.alumno = alumno;
        this.direccion = direccion;
    }

    public Alum getAlumno() {
        return alumno;
    }

    public void setAlumno(Alum alumno) {
        this.alumno = alumno;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}
