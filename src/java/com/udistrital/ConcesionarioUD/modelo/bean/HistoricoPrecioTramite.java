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
public class HistoricoPrecioTramite {

    private int idHistoricoPrecioTramite;
    private int idTramite;
    private int precio;
    private String fecha;

    public int getIdHistoricoPrecioTramite() {
        return idHistoricoPrecioTramite;
    }

    public void setIdHistoricoPrecioTramite(int idHistoricoPrecioTramite) {
        this.idHistoricoPrecioTramite = idHistoricoPrecioTramite;
    }

    public int getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(int idTramite) {
        this.idTramite = idTramite;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
