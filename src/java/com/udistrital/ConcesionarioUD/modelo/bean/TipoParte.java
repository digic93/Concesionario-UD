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
public class TipoParte {

    private int idTipoParte;
    private String Nombre;
    private String Descripcion;

    public int getIdTipoParte() {
        return idTipoParte;
    }

    public void setIdTipoParte(int idTipoParte) {
        this.idTipoParte = idTipoParte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
