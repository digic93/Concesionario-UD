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
public class AcuerdoPago {
    private int idCotizacion;
    private int idAcuerdoPago;
    private int idBanco;
    private int idModalidad;
    private int idGrupoFinanciero;
    private int idTarjeta;
    private int porcentaje;
    private boolean separacion;

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getIdAcuerdoPago() {
        return idAcuerdoPago;
    }

    public void setIdAcuerdoPago(int idAcuerdoPago) {
        this.idAcuerdoPago = idAcuerdoPago;
    }

    public int getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(int idBanco) {
        this.idBanco = idBanco;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdGrupoFinanciero() {
        return idGrupoFinanciero;
    }

    public void setIdGrupoFinanciero(int idGrupoFinanciero) {
        this.idGrupoFinanciero = idGrupoFinanciero;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public boolean getSeparacion() {
        return separacion;
    }

    public void setSeparacion(boolean separacion) {
        this.separacion = separacion;
    }  
    
    
}