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
public class HistoricoPrecioAuto {

    private int idHistoricoPrecio;
    private int precio;
    private String vin;

    public int getIdHistoricoPrecio() {
        return idHistoricoPrecio;
    }

    public void setIdHistoricoPrecio(int idHistoricoPrecio) {
        this.idHistoricoPrecio = idHistoricoPrecio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

}
