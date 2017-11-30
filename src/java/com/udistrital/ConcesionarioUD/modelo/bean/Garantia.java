/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.modelo.bean;

/**
 *
 * @author Diego Castro
 */
public class Garantia {

    private int idGarantia;
    private String fechaInicioGarantia;
    private String fechaFinalizacionGarantia;

    public int getIdGarantia() {
        return idGarantia;
    }

    public void setIdGarantia(int idGarantia) {
        this.idGarantia = idGarantia;
    }

    public String getFechaInicioGarantia() {
        return fechaInicioGarantia;
    }

    public void setFechaInicioGarantia(String fechaInicioGarantia) {
        this.fechaInicioGarantia = fechaInicioGarantia;
    }

    public String getFechaFinalizacionGarantia() {
        return fechaFinalizacionGarantia;
    }

    public void setFechaFinalizacionGarantia(String fechaFinalizacionGarantia) {
        this.fechaFinalizacionGarantia = fechaFinalizacionGarantia;
    }
}
