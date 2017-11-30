/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import java.sql.SQLException;

/**
 *
 * @author Diego Castro
 */
public abstract class AbstractDao {

    protected Statement statement;
    protected ResultSet resultSet;
    protected Connection connection;

    public AbstractDao(){
        connection = Conexion.getConexion();
    }
    
    abstract public Object actualizar(Object object);
    abstract public boolean crear(Object object);
    abstract public boolean borrar(Object object);
    
    abstract public Object getEntityByResultSet(ResultSet resultSet) throws SQLException;
}
