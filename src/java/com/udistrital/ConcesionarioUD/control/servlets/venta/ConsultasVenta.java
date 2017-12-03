/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets.venta;

/**
 *
 * @author Dell
 */
public final class ConsultasVenta {

    public static String getBuscarCotizacionPorCedulaCliente(String cedula) {
        return "SELECT"
                + "    c.IDCOTIZACION,"
                + "    c.FECHAEXPEDICION,"
                + "    c.TOTAL,"
                + "    cl.NOMBRE NOMBRE_CLIENTE,"
                + "    cl.APELLIDO APELLIDO_CLIENTE,"
                + "    v.NOMBRE NOMBRE_VENDEDOR,"
                + "    v.APELLIDO APELLIDO_VENDEDOR,"
                + "    MARCA.NOMBRE||' '||LINEA.NOMBRE CARATERISTICA "
                + "FROM"
                + "    COTIZACION c,"
                + "    CLIENTE cl,"
                + "    EMPLEADO v,"
                + "    STOCKAUTO sta,"
                + "    AUTO au,"
                + "    ("
                + "        SELECT AC.VIN, CA.NOMBRE NOMBRE"
                + "        FROM"
                + "            AUTOCARACTERISTICA AC,"
                + "            CARACTERISTICA CA,"
                + "            TIPOCARACTERISTICA TCA"
                + "        WHERE"
                + "            AC.IDCARACTERISTICA = CA.IDCARACTERISTICA"
                + "        AND CA.IDTIPOCARACTERISTICA = TCA.IDTIPOCARACTERISTICA"
                + "        AND TCA.NOMBRE = 'Marca'"
                + "    ) MARCA,"
                + "   ("
                + "        SELECT AC.VIN, CA.NOMBRE NOMBRE"
                + "        FROM"
                + "            AUTOCARACTERISTICA AC,"
                + "            CARACTERISTICA CA,"
                + "            TIPOCARACTERISTICA TCA"
                + "        WHERE"
                + "            AC.IDCARACTERISTICA = CA.IDCARACTERISTICA"
                + "        AND CA.IDTIPOCARACTERISTICA = TCA.IDTIPOCARACTERISTICA"
                + "        AND TCA.NOMBRE = 'Linea'"
                + "    ) LINEA "
                + "WHERE"
                + "    sta.IDCOTIZACION = c.IDCOTIZACION "
                + "AND sta.VIN = AU.VIN "
                + "AND c.CEDULA = cl.CEDULA "
                + "AND c.IDEMPELADO = v.IDEMPELADO "
                + "AND AU.VIN = MARCA.VIN "
                + "AND AU.VIN = LINEA.VIN "
                + "AND MONTHS_BETWEEN(SYSDATE, c.FECHAEXPEDICION) < 1 "
                + "AND cl.CEDULA = " + cedula;
    }

    public static String getCotizacionCompletaById(int idcotizacion) {
        return "SELECT"
                + "    c.IDCOTIZACION,"
                + "    c.FECHAEXPEDICION,"
                + "    c.TOTAL,"
                + "    cl.CEDULA,"
                + "    v.NOMBRE NOMBRE_VENDEDOR,"
                + "    v.APELLIDO APELLIDO_VENDEDOR,"
                + "    au.VIN "
                + "FROM "
                + "    COTIZACION c,"
                + "    CLIENTE cl,"
                + "    EMPLEADO v,"
                + "    STOCKAUTO sta,"
                + "    AUTO au "
                + "WHERE  "
                + "    c.IDCOTIZACION = " + idcotizacion + " "
                + "AND  sta.IDCOTIZACION = c.IDCOTIZACION "
                + "AND sta.VIN = AU.VIN "
                + "AND c.CEDULA = cl.CEDULA "
                + "AND c.IDEMPELADO = v.IDEMPELADO ";
    }
}
