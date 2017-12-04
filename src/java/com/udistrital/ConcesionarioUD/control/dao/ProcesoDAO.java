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
public class ProcesoDAO extends AbstractDao {

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

    public int guardar(int idEmpelado,int numCotizacion) {
        int r = 0;
        Calendar calendar = Calendar.getInstance();
        String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
        
        String insert = "INSERT INTO PROCESO (IDPROCESO,IDTIPOPROCESO,IDEMPELADO,IDCOTIZACION,FECHAINICIOPROCESO,FECHAFINALIZACIONPROCESO) VALUES (SEQUENCE_PROCESO.NEXTVAL,1,"+idEmpelado+","+numCotizacion+",to_date('"+fecha+"','DD/MM/YYYY')"+",to_date('"+fecha+"','DD/MM/YYYY'))";
        System.out.println(insert);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            r = this.statement.executeUpdate(insert);
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar el insert: "+ex.getMessage());

        } finally {
            Conexion.desconectar();
        }
        return r;
    }

}