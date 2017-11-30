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
public class TipoProceso {

    private int idTipoProceso;
    private String estadoProceso;
    private String descripcionTipoProceso;

    public int getIdTipoProceso() {
        return idTipoProceso;
    }

    public void setIdTipoProceso(int idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public String getDescripcionTipoProceso() {
        return descripcionTipoProceso;
    }

    public void setDescripcionTipoProceso(String descripcionTipoProceso) {
        this.descripcionTipoProceso = descripcionTipoProceso;
    }

}
