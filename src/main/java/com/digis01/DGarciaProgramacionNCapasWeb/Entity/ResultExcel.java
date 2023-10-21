/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.DGarciaProgramacionNCapasWeb.Entity;

import java.util.List;

/**
 *
 * @author ALIEN 61
 */
public class ResultExcel {
    private int Row;
    private String ErrorMessage;
    private List Errores;

    public List getErrores() {
        return Errores;
    }

    public void setErrores(List Errores) {
        this.Errores = Errores;
    }
    
    public ResultExcel() {
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int Row) {
        this.Row = Row;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }
    
    
}
