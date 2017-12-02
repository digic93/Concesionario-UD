/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.modelo.bean.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Santiag
 */
public class ClienteDAO extends AbstractDao{

    
    public Cliente buscarCliente(String cedula){
        Cliente cliente = null;
        String consulta = "SELECT * FROM CLIENTE where CEDULA = '" + cedula + "'";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            
            if (resultSet.next()){
                cliente = (Cliente) this.getEntityByResultSet(resultSet);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        if (cliente!= null) {
            return cliente;
        } else {
            return null;
        }      
        
    }
    
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
        Cliente cliente = new Cliente();
        cliente.setCedula(resultSet.getInt("CEDULA"));
        cliente.setNombre(resultSet.getString("NOMBRE"));
        cliente.setApellido(resultSet.getString("APELLIDO"));
        cliente.setFechaNacimiento(resultSet.getString("FECHANACIMIENTO"));
        cliente.setDireccionResidencia(resultSet.getString("DIRECCIONRESIDENCIA"));
        return cliente;
    }

    private boolean validacionCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
