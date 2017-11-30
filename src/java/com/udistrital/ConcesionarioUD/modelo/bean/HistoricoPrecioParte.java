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
public class HistoricoPrecioParte {
    private int idHistoricoPrecioParte;
    private int idParte;
    private int precioParte;

    public int getIdHistoricoPrecioParte() {
        return idHistoricoPrecioParte;
    }

    public void setIdHistoricoPrecioParte(int idHistoricoPrecioParte) {
        this.idHistoricoPrecioParte = idHistoricoPrecioParte;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    public int getPrecioParte() {
        return precioParte;
    }

    public void setPrecioParte(int precioParte) {
        this.precioParte = precioParte;
    }
    
}
