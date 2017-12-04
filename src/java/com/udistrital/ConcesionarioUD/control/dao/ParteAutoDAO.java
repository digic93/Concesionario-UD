/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Diego Castro
 */
public class ParteAutoDAO extends AbstractDao {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public int guardar(String[] partes, String vin) {
        
        int r = 0;
        
        for (String parte : partes) {
            String insert = "INSERT INTO PARTEAUTO (IDSEQUENCE,IDPARTEAUTO,VIN,PRECIO) VALUES (SEQUENCE_HISTORICOPAGOS.NEXTVAL,"+Integer.parseInt(parte)+",'"+vin+"',(SELECT PRECIOPARTE FROM HISTORICOPRECIOPARTE WHERE IDPARTE="+Integer.parseInt(parte)+"))";
            System.out.println(insert);
            try {
                this.connection = Conexion.getConexion();
                this.statement = connection.createStatement();
                r = this.statement.executeUpdate(insert);
                statement.close();
            } catch (SQLException ex) {
                System.out.println("No se pudo realizar la consulta: "+ex.getMessage());

            } finally {
                Conexion.desconectar();
            }
        }
        
        
        return r;
    }

}