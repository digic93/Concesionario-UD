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
public class Registro {

    private int idRegistro;
    private int idTipoRegistro;
    private int idAseguradora;
    private int idEmpelado;
    private int Emp_idEmpelado;
    private int idCotizacion;
    private String placa;
    private int LicenciaTransito;

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getIdTipoRegistro() {
        return idTipoRegistro;
    }

    public void setIdTipoRegistro(int idTipoRegistro) {
        this.idTipoRegistro = idTipoRegistro;
    }

    public int getIdAseguradora() {
        return idAseguradora;
    }

    public void setIdAseguradora(int idAseguradora) {
        this.idAseguradora = idAseguradora;
    }

    public int getIdEmpelado() {
        return idEmpelado;
    }

    public void setIdEmpelado(int idEmpelado) {
        this.idEmpelado = idEmpelado;
    }

    public int getEmp_idEmpelado() {
        return Emp_idEmpelado;
    }

    public void setEmp_idEmpelado(int Emp_idEmpelado) {
        this.Emp_idEmpelado = Emp_idEmpelado;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getLicenciaTransito() {
        return LicenciaTransito;
    }

    public void setLicenciaTransito(int LicenciaTransito) {
        this.LicenciaTransito = LicenciaTransito;
    }
    
    
}
