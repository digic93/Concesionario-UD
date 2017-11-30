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
public class StockParte {

    private int idStockParte;
    private int idFactura;
    private int idDetalleFactura;
    private int idEstadoStockParte;
    private int idTipoMovimiento;
    private int idParte;
    private int idCotizacion;
    private int idDetalle;

    public int getIdStockParte() {
        return idStockParte;
    }

    public void setIdStockParte(int idStockParte) {
        this.idStockParte = idStockParte;
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

    public int getIdEstadoStockParte() {
        return idEstadoStockParte;
    }

    public void setIdEstadoStockParte(int idEstadoStockParte) {
        this.idEstadoStockParte = idEstadoStockParte;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
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
