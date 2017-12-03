/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.Parte;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Diego Castro
 */
public class ParteDAO extends AbstractDao {

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
        Parte parte = new Parte();
        parte.setIdParte(resultSet.getInt("IDPARTE"));
        parte.setIdTipoParte(resultSet.getInt("IDTIPOPARTE"));
        parte.setNombre(resultSet.getString("NOMBRE"));        
        return parte;
    }

    public ArrayList<Parte> consultarPartes() {
        ArrayList partes = new ArrayList();
        String consulta = "SELECT * FROM PARTE ORDER BY IDTIPOPARTE";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                partes.add((Parte) this.getEntityByResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return partes;
        
    }

}