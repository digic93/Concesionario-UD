/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.ConcesionarioUD.control.servlets.venta.ConsultasVenta;
import com.udistrital.ConcesionarioUD.modelo.bean.Caracteristica;
import com.udistrital.ConcesionarioUD.modelo.bean.Cliente;
import com.udistrital.ConcesionarioUD.modelo.bean.Cotizacion;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import com.udistrital.ConcesionarioUD.modelo.bean.TipoCaracteristica;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
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

    public int guardarCotizacion(String cedula, int idEmpelado, long total) {
        Calendar calendar = Calendar.getInstance();
        String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
        int r = 0;
        String insert = "INSERT INTO COTIZACION (IDCOTIZACION,CEDULA,IDEMPELADO,FECHAEXPEDICION,TOTAL) VALUES (NULL," + Integer.parseInt(cedula) + "," + idEmpelado + ",to_date('" + fecha + "','DD/MM/YYYY')," + total + ")";
        System.out.println(insert);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            r = this.statement.executeUpdate(insert);
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());

        } finally {
            Conexion.desconectar();
        }
        return r;
    }

    public Object obtenerTotalPartes(String[] partes) {
        long total = 0;
        String id = "";

        for (String parte : partes) {
            id = id.concat(parte + ",");
        }
        id = id.substring(0, id.length() - 1);
        System.out.println("ID: " + id);
        String consulta = " SELECT SUM(PRECIOPARTE) TOTAL FROM HISTORICOPRECIOPARTE WHERE IDPARTE IN(" + id + ")";

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

        String consulta = " SELECT PRECIO TOTAL FROM HISTORICOPRECIOSAUTO WHERE VIN = '" + vin + "'";

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

    public ArrayList<Map<String, Object>> buscarPorCedulaCliente(String cedula) {
        ArrayList<Map<String, Object>> cotizaciones = new ArrayList();

        String consulta = ConsultasVenta.getBuscarCotizacionPorCedulaCliente(cedula);

        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
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

                HashMap<String, Object> map = new HashMap();
                map.put("cotizacion", cotizacion);
                map.put("cliente", cliente);
                map.put("empleado", empleado);
                map.put("caracteristca", caracteristca);

                cotizaciones.add(map);
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return cotizaciones;
    }

    public Map<String, Object> getAllCotizacionById(int idcotizacion) {
        
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Map<String, Object>> cotizaciones = new ArrayList();

        ClienteDAO clienteDAO = new ClienteDAO();
        CaracteristicaDAO caracteristicaDAO = new CaracteristicaDAO();
        TipoCaracteristicaDAO tipoCaracteristicaDAO = new TipoCaracteristicaDAO();

        String consulta = ConsultasVenta.getCotizacionCompletaById(idcotizacion);
        ArrayList<TipoCaracteristica> tipoCaracteristicas = tipoCaracteristicaDAO.cargarCaracteristicas();
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                Cotizacion cotizacion = new Cotizacion();

                cotizacion.setIdCotizacion(resultSet.getInt(1));
                cotizacion.setFechaExpedicion(resultSet.getString(2).substring(0, 10));
                cotizacion.setTotal(resultSet.getInt(3));

                empleado.setNombre(resultSet.getString(5));
                empleado.setApellido(resultSet.getString(6));

                Cliente cliente = clienteDAO.buscarCliente(resultSet.getString(4));
                ArrayList<Caracteristica> caracteristicas = caracteristicaDAO.obtenerCaracteristicas(resultSet.getString(7));

                map.put("cotizacion", cotizacion);
                map.put("cliente", cliente);
                map.put("empleados", empleado);
                map.put("caracteristcas", caracteristicas);
                map.put("tipoCaracteristicas", tipoCaracteristicas);

            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return map;
    }

    public ArrayList<Map<String, Object>> cotizacionAprobarCreditoPorCCCliente(String cedula) {
               ArrayList<Map<String, Object>> cotizaciones = new ArrayList();

        String consulta = ConsultasVenta.getBuscarcotizacionAprobarCreditoPorCCCliente(cedula);

        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);

            while (resultSet.next()) {
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

                HashMap<String, Object> map = new HashMap();
                map.put("cotizacion", cotizacion);
                map.put("cliente", cliente);
                map.put("empleado", empleado);
                map.put("caracteristca", caracteristca);

                cotizaciones.add(map);
            }

            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: " + ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        return cotizaciones;
    }

    public int obtenerCotizacion() {
        int r = 0;
        
        String select = "SELECT IDCOTIZACION FROM COTIZACION WHERE ROWNUM=1 ORDER BY IDCOTIZACION DESC";        
        System.out.println(select);
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(select);
            if(resultSet.next()){
                r = resultSet.getInt("IDCOTIZACION");
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar el insert: "+ex.getMessage());

        } finally {
            Conexion.desconectar();
        }
        return r;
    }
}
