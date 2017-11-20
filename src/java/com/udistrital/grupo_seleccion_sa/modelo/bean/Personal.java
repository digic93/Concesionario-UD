/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.grupo_seleccion_sa.modelo.bean;

/**
 *
 * @author Diego Castro
 */
public class Personal {

    private int id;
    private String nombre;
    private String usuario;
    private String password;
    private String fechaRegistro;
    private String fechaUltimoIngreso;
    private String rolNombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaUltimoIngreso() {
        return fechaUltimoIngreso;
    }

    public void setFechaUltimoIngreso(String fechaUltimoIngreso) {
        this.fechaUltimoIngreso = fechaUltimoIngreso;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
}
