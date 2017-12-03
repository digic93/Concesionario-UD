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
public class CotizacionDAO extends AbstractDao {

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

    public int guardarCotizacion(String cedula, int idEmpelado,long total) {
        Calendar calendar = Calendar.getInstance();
        String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
        int r = 0;
        String insert = "INSERT INTO COTIZACION (IDCOTIZACION,CEDULA,IDEMPELADO,FECHAEXPEDICION,TOTAL) VALUES (NULL,"+Integer.parseInt(cedula)+","+idEmpelado+",to_date('"+fecha+"','DD/MM/YYYY'),"+total+")";
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
        return r;
    }

    public Object obtenerTotalPartes(String[] partes) {
        long total = 0;
        String id = "";
        
        for (String parte : partes) {
            id = id.concat(parte+",");
        }   
        id = id.substring(0, id.length()-1);
        System.out.println("ID: "+id);
        String consulta = " SELECT SUM(PRECIOPARTE) TOTAL FROM HISTORICOPRECIOPARTE WHERE IDPARTE IN("+id+")";
        
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            if (resultSet.next()) {
                 total = resultSet.getInt("TOTAL");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }
        
        
        return total;
    }
    
    public Object obtenerTotalAuto(String vin) {
        long total = 0;
             
        String consulta = " SELECT PRECIO TOTAL FROM HISTORICOPRECIOSAUTO WHERE VIN = '"+vin+"'";
        
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            if (resultSet.next()) {
                 total = resultSet.getInt("TOTAL");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }      
        
        return total;
    }

}