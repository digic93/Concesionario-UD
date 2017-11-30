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
public class StockAuto {

    private int idStockAuto;
    private int idFactura;
    private int idDetalleFactura;
    private int idEstadoStockAuto;
    private String vin;
    private int idTipoMovimiento;
    private int idCotizacion;
    private int idDetalle;

    public int getIdStockAuto() {
        return idStockAuto;
    }

    public void setIdStockAuto(int idStockAuto) {
        this.idStockAuto = idStockAuto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdEstadoStockAuto() {
        return idEstadoStockAuto;
    }

    public void setIdEstadoStockAuto(int idEstadoStockAuto) {
        this.idEstadoStockAuto = idEstadoStockAuto;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

}
