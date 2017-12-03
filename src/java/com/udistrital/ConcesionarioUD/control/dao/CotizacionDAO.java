/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.sun.faces.util.CollectionsUtils;
import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.control.servlets.venta.ConsultasVenta;
import com.udistrital.ConcesionarioUD.modelo.bean.Caracteristica;
import com.udistrital.ConcesionarioUD.modelo.bean.Cliente;
import com.udistrital.ConcesionarioUD.modelo.bean.Cotizacion;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    public ArrayList<Map<String, Object>> buscarPorCedulaCliente(String cedula) {
        ArrayList<Map<String, Object>> cotizaciones = new ArrayList();
        
        String consulta =  ConsultasVenta.getBuscarCotizacionPorCedulaCliente(cedula);
        
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            
            while(resultSet.next()){
                Cliente cliente = new Cliente();
                Empleado empleado = new Empleado();
                Caracteristica caracteristca = new Caracteristica();
                Cotizacion cotizacion = new Cotizacion();
                
                cotizacion.setIdCotizacion(resultSet.getInt(1));
                cotizacion.setFechaExpedicion(resultSet.getString(2).substring(0, 10));
                cotizacion.setTotal(resultSet.getInt(3));
                
                cliente.setNombre(resultSet.getString(4));
                cliente.setApellido(resultSet.getString(5));
                
                empleado.setNombre(resultSet.getString(6));
                empleado.setApellido(resultSet.getString(7));

                caracteristca.setNombre(resultSet.getString(8));
                
                HashMap<String, Object> map = new CollectionsUtils.ConstMap<>();
                map.put("cotizacion", cotizacion);
                map.put("cliente", cliente);
                map.put("empleado", empleado);
                map.put("caracteristca", caracteristca);
                
                cotizaciones.add(map);
            }
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return cotizaciones;
    }
    
    public ArrayList<Map<String, Object>> getAllCotizacionById(int idcotizacion) {
                ArrayList<Map<String, Object>> cotizaciones = new ArrayList();
        ClienteDAO clienteDAO = new ClienteDAO();
        String consulta =  ConsultasVenta.getCotizacionCompletaById(idcotizacion);
        
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            
            while(resultSet.next()){
                Empleado empleado = new Empleado();
                Caracteristica caracteristca = new Caracteristica();
                Cotizacion cotizacion = new Cotizacion();
                
                cotizacion.setIdCotizacion(resultSet.getInt(1));
                cotizacion.setFechaExpedicion(resultSet.getString(2).substring(0, 10));
                cotizacion.setTotal(resultSet.getInt(3));
                
                empleado.setNombre(resultSet.getString(6));
                empleado.setApellido(resultSet.getString(7));
                
                Cliente cliente = clienteDAO.buscarCliente(resultSet.getString(4));
                
                HashMap<String, Object> map = new CollectionsUtils.ConstMap<>();
                map.put("cotizacion", cotizacion);
                map.put("cliente", cliente);
                map.put("empleado", empleado);
                map.put("caracteristca", caracteristca);
                
                cotizaciones.add(map);
            }
            
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return cotizaciones;
    }

}