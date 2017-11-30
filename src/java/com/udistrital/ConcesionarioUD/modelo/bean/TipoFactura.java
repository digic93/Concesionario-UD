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
public class TipoFactura {

    private int idTipoFactura;
    private String descripcionTipoFactura;

    public int getIdTipoFactura() {
        return idTipoFactura;
    }

    public void setIdTipoFactura(int idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public String getDescripcionTipoFactura() {
        return descripcionTipoFactura;
    }

    public void setDescripcionTipoFactura(String descripcionTipoFactura) {
        this.descripcionTipoFactura = descripcionTipoFactura;
    }

}
