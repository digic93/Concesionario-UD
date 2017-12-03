/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.AutoCaracteristica;
import com.udistrital.ConcesionarioUD.modelo.bean.Caracteristica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego Castro
 */
public class AutoCaracteristicaDAO extends AbstractDao {

    @Override
    public Object actualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getEntityByResultSet(ResultSet resultSet) throws SQLException {
        AutoCaracteristica c = new AutoCaracteristica();
        c.setIdCaracteristica(resultSet.getInt("IDCARACTERISSTICA"));
        c.setVin(resultSet.getString("VIN"));
        return c;
    }

    public ArrayList consultarIDforVIN(String vin) {
        ArrayList idCaracteristicas = new ArrayList();
        String consulta = "SELECT * FROM AUTOCARACTERISTICA WHERE VIN='"+vin+"'";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            
            while(resultSet.next()){
                idCaracteristicas.add((Caracteristica) this.getEntityByResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return idCaracteristicas;
    }

}