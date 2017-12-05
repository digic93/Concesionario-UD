/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Castro
 */
public class StockAutoDAO  extends AbstractDao {

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

    public void guardar(int numCotizacion, String vin) {        
        
        String insert = "INSERT INTO STOCKAUTO (IDSTOCKAUTO,IDFACTURA,IDDETALLEFACTURA,IDESTADOSTOCKAUTO,VIN,IDTIPOMOVIMIENTO,IDCOTIZACION,IDDETALLE) VALUES (null,null,null,1,'"+vin+"',1,"+numCotizacion+",null)";
        System.out.println(insert);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.statement.executeUpdate(insert);
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar el insert: "+ex.getMessage());

        } finally {
            Conexion.desconectar();
        }
    }

}