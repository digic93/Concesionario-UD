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
public class HistoricoPrecioRegistro {

    private int idHistoricoPrecioRegistro;
    private int idRegistro;
    private int precioRegistro;

    public int getIdHistoricoPrecioRegistro() {
        return idHistoricoPrecioRegistro;
    }

    public void setIdHistoricoPrecioRegistro(int idHistoricoPrecioRegistro) {
        this.idHistoricoPrecioRegistro = idHistoricoPrecioRegistro;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getPrecioRegistro() {
        return precioRegistro;
    }

    public void setPrecioRegistro(int precioRegistro) {
        this.precioRegistro = precioRegistro;
    }

}
