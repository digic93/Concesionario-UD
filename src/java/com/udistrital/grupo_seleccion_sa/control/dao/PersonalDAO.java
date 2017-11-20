/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.grupo_seleccion_sa.control.dao;

import com.udistrital.ConcesionarioUD.conexion.Conexion;
import com.udistrital.grupo_seleccion_sa.modelo.bean.Personal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Diego Castro
 */
public class PersonalDAO extends AbstractDao {

    public Personal login(String usuario, String password) {
        Personal persona = null;
        String consulta = "SELECT * FROM PERSONAL where USUARIO = '" + usuario + "' and PASSWORD = '" + password + "'";
        try {
            this.connection = Conexion.getConexion();
            this.statement = connection.createStatement();
            this.resultSet = statement.executeQuery(consulta);
            if (resultSet.next()) {
                persona = (Personal) this.getEntityByResultSet(resultSet);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
            return null;
        } finally {
            Conexion.desconectar();
        }

        if (validacionLogin(persona)) {
            return persona;
        } else {
            return null;
        }
    }

    @Override
    public Object actualizar(Object object) {
        Personal personal = (Personal)object;
        try {
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
        }
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
        Personal persona = new Personal();

        persona.setId(resultSet.getInt("ID"));
        persona.setNombre(resultSet.getString("NOMBRE"));
        persona.setPassword(resultSet.getString("PASSWORD"));
        persona.setFechaUltimoIngreso(resultSet.getString("FECHA_ULTIMO_INGRESO"));
        persona.setRolNombre(resultSet.getString("ROL_NOMBRE"));

        return persona;
    }

    private boolean validacionLogin(Personal persona) {
        if (persona == null) {
            return false;
        }
        if (persona.getRolNombre().equals("Analista")) {
            Calendar calendar = Calendar.getInstance();
            String fecha = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
            persona.setFechaUltimoIngreso(fecha);
            actualizar(persona);
            return true;
        }
        return false;
    }

}
