/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Diego Castro
 */
public class HistoricoAccionesDAO extends AbstractDao {

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

    public void accionLogin(Empleado empleado) {
        Calendar calendar = Calendar.getInstance();
        String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
        System.out.println(fecha);
        String insert = "INSERT INTO HISTORICOACCIONES (IDHISTORICO,IDEMPELADO,FECHAACCION,DESCRIPCIONMODIFICACION) VALUES (NULL,"+empleado.getIdEmpelado()+",to_date('"+fecha+"','DD/MM/YYYY'),'Inicio sesion en el sistema')";
        //System.out.println(insert);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            int r = this.statement.executeUpdate(insert);
            System.out.println("Respuesta: "+r);

            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            
        } finally {
            Conexion.desconectar();
        }
    }

}
