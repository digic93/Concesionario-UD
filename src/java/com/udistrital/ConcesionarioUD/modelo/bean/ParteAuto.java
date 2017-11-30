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
public class ParteAuto {

    private int idParteAuto;
    private String vin;
    private int precio;

    public int getIdParteAuto() {
        return idParteAuto;
    }

    public void setIdParteAuto(int idParteAuto) {
        this.idParteAuto = idParteAuto;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
