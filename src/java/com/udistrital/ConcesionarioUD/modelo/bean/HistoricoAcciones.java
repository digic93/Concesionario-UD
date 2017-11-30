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
public class HistoricoAcciones {

    private int idHistorico;
    private int idEmpelado;
    private String fechaAccion;
    private String descripcionModificacion;

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public int getIdEmpelado() {
        return idEmpelado;
    }

    public void setIdEmpelado(int idEmpelado) {
        this.idEmpelado = idEmpelado;
    }

    public String getFechaAccion() {
        return fechaAccion;
    }

    public void setFechaAccion(String fechaAccion) {
        this.fechaAccion = fechaAccion;
    }

    public String getDescripcionModificacion() {
        return descripcionModificacion;
    }

    public void setDescripcionModificacion(String descripcionModificacion) {
        this.descripcionModificacion = descripcionModificacion;
    }
}
