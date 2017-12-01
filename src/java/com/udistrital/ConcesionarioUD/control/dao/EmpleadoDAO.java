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
public class EmpleadoDAO extends AbstractDao {

    public Empleado login(String usuario, String password) {
        Empleado empleado = null;
        String consulta = "SELECT * FROM EMPLEADO where NOMBRE = '" + usuario + "' and PASSWORD = '" + password + "'";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            
            if (resultSet.next()){
                empleado = (Empleado) this.getEntityByResultSet(resultSet);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta: "+ex.getMessage());
            return null;
        } finally {
            Conexion.desconectar();
        }

        if (validacionLogin(empleado)) {
            return empleado;
        } else {
            return null;
        }
    }

    @Override
    public Object actualizar(Object object) {
        Empleado personal = (Empleado)object;
        /*try {
            this.connection = Conexion.getConexion();
            this.statement = this.connection.createStatement();
            String insercion = "UPDATE PERSONAL SET NOMBRE = '" + personal.getNombre() + "', "
                    + "PASSWORD = '" + personal.getPassword() + "', "
                    + "FECHA_ULTIMO_INGRESO = '" + personal.getFechaUltimoIngreso()+ "', "
                    + "ROL_NOMBRE = '" + personal.getRolNombre()+ "' "
                    + "WHERE ID = " + personal.getId();
            System.out.print(insercion);
            statement.executeUpdate(insercion);
            statement.close();
            return true;
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
            return false;
        } finally {
            Conexion.desconectar();
        }*/
        return null;
    }

    @Override
    public boolean crear(Object object) {
//        try {
//            this.connection = Conexion.getConexion();
//            this.statement = connection.createStatement();
//            String insercion = "INSERT INTO PERSONAL (ID, NOMBRE, Password, )"
//                    + "VALUES(" + id + ",'" + name + "','" + Password + "')";
//            System.out.print(insercion);
//            st.executeUpdate(insercion);
//            st.close();
//            return true;
//        } catch (SQLException ex) {
//            System.out.print("No se pudo realizar la insercion");
//            return false;
//        } finally {
//            ConnectionTest.desconectar();
//        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getEntityByResultSet(ResultSet resultSet) throws SQLException {
        Empleado empleado = new Empleado();

        empleado.setIdEmpelado(resultSet.getInt("IDEMPELADO"));        
        empleado.setIdArea(resultSet.getInt("IDAREA"));
        empleado.setIdDepto(resultSet.getInt("IDDEPTO"));
        empleado.setNombre(resultSet.getString("NOMBRE"));
        empleado.setApellido(resultSet.getString("APELLIDO"));
        empleado.setCargo(resultSet.getString("CARGO"));
        empleado.setSalario(resultSet.getString("SALARIO"));         
        
        //IDEMPELADO,IDAREA,IDDEPTO,NOMBRE,APELLIDO,CARGO,SALARIO,PASSWORD
        return empleado;
    }

    private boolean validacionLogin(Empleado empleado) {
        if (empleado == null) {
            return false;
        }
        if (empleado.getCargo().equals("vendedor") || empleado.getCargo().equals("Vendedor")) {
            Calendar calendar = Calendar.getInstance();
            String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
            
            actualizar(empleado);
            return true;
        }
        return false;
      
    }

}
