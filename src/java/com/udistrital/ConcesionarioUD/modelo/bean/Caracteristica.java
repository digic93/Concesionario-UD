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
public class Caracteristica {

    private int idCaracteristica;
    private String nombre;
    private String descripcion;
    private int Car_idCaracteristica;
    private int idTipoCaracteristica;

    public int getIdCaracteristica() {
        return idCaracteristica;
    }

    public void setIdCaracteristica(int idCaracteristica) {
        this.idCaracteristica = idCaracteristica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCar_idCaracteristica() {
        return Car_idCaracteristica;
    }

    public void setCar_idCaracteristica(int Car_idCaracteristica) {
        this.Car_idCaracteristica = Car_idCaracteristica;
    }

    public int getIdTipoCaracteristica() {
        return idTipoCaracteristica;
    }

    public void setIdTipoCaracteristica(int idTipoCaracteristica) {
        this.idTipoCaracteristica = idTipoCaracteristica;
    }
    
    
}
