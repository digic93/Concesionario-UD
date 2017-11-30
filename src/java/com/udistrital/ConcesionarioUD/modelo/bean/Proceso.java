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
public class Proceso {

    private int idProceso;
    private int idTipoProceso;
    private int idEmpelado;
    private int idCotizacion;
    private String fechaInicioProceso;
    private String fechaFinalizacionProceso;

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public int getIdTipoProceso() {
        return idTipoProceso;
    }

    public void setIdTipoProceso(int idTipoProceso) {
        this.idTipoProceso = idTipoProceso;
    }

    public int getIdEmpelado() {
        return idEmpelado;
    }

    public void setIdEmpelado(int idEmpelado) {
        this.idEmpelado = idEmpelado;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getFechaInicioProceso() {
        return fechaInicioProceso;
    }

    public void setFechaInicioProceso(String fechaInicioProceso) {
        this.fechaInicioProceso = fechaInicioProceso;
    }

    public String getFechaFinalizacionProceso() {
        return fechaFinalizacionProceso;
    }

    public void setFechaFinalizacionProceso(String fechaFinalizacionProceso) {
        this.fechaFinalizacionProceso = fechaFinalizacionProceso;
    }
}
