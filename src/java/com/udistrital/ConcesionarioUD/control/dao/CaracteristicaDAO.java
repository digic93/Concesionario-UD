/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.Caracteristica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego Castro
 */
public class CaracteristicaDAO extends AbstractDao {

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
        Caracteristica c = new Caracteristica();
        c.setIdCaracteristica(resultSet.getInt("IDCARACTERISTICA"));
        c.setNombre(resultSet.getString("NOMBRE"));
        c.setDescripcion(resultSet.getString("DESCRIPCION"));
        c.setCar_idCaracteristica(resultSet.getInt("CAR_IDCARACTERISTICA"));
        c.setIdTipoCaracteristica(resultSet.getInt("IDTIPOCARACTERISTICA"));
        
        return c;   
    }

    public ArrayList<Caracteristica> obtenerCaracteristicas(String vin) {
        ArrayList caracteristicas = new ArrayList();
        String consulta = "SELECT * FROM CARACTERISTICA WHERE IDCARACTERISTICA IN (SELECT IDCARACTERISTICA FROM AUTOCARACTERISTICA WHERE VIN='" + vin + "')";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                caracteristicas.add((Caracteristica) this.getEntityByResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return caracteristicas;
    }

}
