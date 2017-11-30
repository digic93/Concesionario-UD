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
public class TipoTarjeta {

    private int idTipoTarjeta;
    private String nombreTipoTarjeta;
    private String descripcionTarjeta;

    public int getIdTipoTarjeta() {
        return idTipoTarjeta;
    }

    public void setIdTipoTarjeta(int idTipoTarjeta) {
        this.idTipoTarjeta = idTipoTarjeta;
    }

    public String getNombreTipoTarjeta() {
        return nombreTipoTarjeta;
    }

    public void setNombreTipoTarjeta(String nombreTipoTarjeta) {
        this.nombreTipoTarjeta = nombreTipoTarjeta;
    }

    public String getDescripcionTarjeta() {
        return descripcionTarjeta;
    }

    public void setDescripcionTarjeta(String descripcionTarjeta) {
        this.descripcionTarjeta = descripcionTarjeta;
    }

}
