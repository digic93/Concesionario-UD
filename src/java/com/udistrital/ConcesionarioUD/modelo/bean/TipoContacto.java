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
public class TipoContacto {

    private int idTipoContacto;
    private String nombreTipoContacto;
    private String descripcionTipoContacto;

    public int getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(int idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    public String getNombreTipoContacto() {
        return nombreTipoContacto;
    }

    public void setNombreTipoContacto(String nombreTipoContacto) {
        this.nombreTipoContacto = nombreTipoContacto;
    }

    public String getDescripcionTipoContacto() {
        return descripcionTipoContacto;
    }

    public void setDescripcionTipoContacto(String descripcionTipoContacto) {
        this.descripcionTipoContacto = descripcionTipoContacto;
    }

}
