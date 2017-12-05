/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.AcuerdoPago;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego Castro
 */
public class AcuerdoPagoDAO extends AbstractDao {

    @Override
    public Object actualizar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean crear(Object object) {
        AcuerdoPago acuerdo = (AcuerdoPago) object;
        String idBanco;
        if (acuerdo.getIdBanco() == 0) {
            idBanco = "null";
        } else {
           idBanco =  acuerdo.getIdBanco() + "";
        }
        String insert = "INSERT INTO ACUERDOPAGO(IDCOTIZACION,IDACUERDOPAGO, IDBANCO, IDMODALIDAD, PORCENTAJE, SEPARACION) VALUES ('" + acuerdo.getIdCotizacion() + "', null, " + idBanco + ", " + acuerdo.getIdModalidad() + ", " + acuerdo.getPorcentaje() + ", '" + acuerdo.getSeparacion() + "')";

//        System.out.println(insert);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
//            r = this.statement.executeUpdate(insert);
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());

        } finally {
            Conexion.desconectar();
        }

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

}
