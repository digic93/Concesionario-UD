/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets.venta;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.udistrital.ConcesionarioUD.control.dao.AcuerdoPagoDAO;
import com.udistrital.ConcesionarioUD.control.dao.ProcesoDAO;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import com.udistrital.ConcesionarioUD.modelo.bean.ModalidadPago;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "AcuerdoPago", urlPatterns = {"/venta/acuerdoPago"})
public class AcuerdoPago extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("../Web/AcuerdoPagoView.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idModalidad;
        int porcentaje;
        boolean flagAcurdo = false;

        AcuerdoPagoDAO acuedoPagoDAO = new AcuerdoPagoDAO();
        com.udistrital.ConcesionarioUD.modelo.bean.AcuerdoPago acuerdo;
        String data = request.getParameter("data");
        JsonElement jelement = new JsonParser().parse(data);
        JsonObject jobject = jelement.getAsJsonObject();
        int idCotizacion = Integer.parseInt(jobject.get("idcotizacion").toString());

        JsonArray Acuerdos30 = jobject.getAsJsonArray("acuerdos30");
        for (JsonElement acuerdoElemnt : Acuerdos30) {
            JsonObject acuerdoObj = acuerdoElemnt.getAsJsonObject();
            acuerdo = new com.udistrital.ConcesionarioUD.modelo.bean.AcuerdoPago();

            acuerdo.setIdCotizacion(idCotizacion);

            idModalidad = Integer.parseInt(acuerdoObj.get("metodoAcuerdo").getAsString());
            porcentaje = (int) (Integer.parseInt(acuerdoObj.get("porcentaje").getAsString()) * 0.3);

            acuerdo.setIdModalidad(idModalidad);
            acuerdo.setPorcentaje(porcentaje);
            if (idModalidad != 1) {
                acuerdo.setIdBanco(Integer.parseInt(acuerdoObj.get("banco").getAsString()));
            } else if (idModalidad == 4) {
                flagAcurdo = true;
            }

            acuedoPagoDAO.crear(acuerdo);
        }

        JsonArray Acuerdos70 = jobject.getAsJsonArray("acuerdos70");
        for (JsonElement acuerdoElemnt : Acuerdos70) {
            JsonObject acuerdoObj = acuerdoElemnt.getAsJsonObject();
            acuerdo = new com.udistrital.ConcesionarioUD.modelo.bean.AcuerdoPago();

            acuerdo.setIdCotizacion(idCotizacion);

            idModalidad = Integer.parseInt(acuerdoObj.get("metodoAcuerdo").getAsString());
            porcentaje = (int) (Integer.parseInt(acuerdoObj.get("porcentaje").getAsString()) * 0.7);

            acuerdo.setIdModalidad(idModalidad);
            acuerdo.setPorcentaje(porcentaje);
            if (idModalidad != 1) {
                acuerdo.setIdBanco(Integer.parseInt(acuerdoObj.get("banco").toString()));
            } else if (idModalidad == 4) {
                flagAcurdo = true;
            }

            acuedoPagoDAO.crear(acuerdo);
        }

        /// validar
        ProcesoDAO procesoDAO = new ProcesoDAO();
        Empleado empleado = (Empleado) request.getSession().getAttribute("empleado");

        if (flagAcurdo) {
            //proceso tiene que se estudio credito 
            procesoDAO.actualizarEstadoProcesoEstudioCredito(idCotizacion, empleado.getIdEmpelado());
            response.sendRedirect("./venta/estudioCredito");
        } else {
            //proceso tiene que se acuerdo pago 
            procesoDAO.actualizarEstadoProcesoAcuerdoPago(idCotizacion, empleado.getIdEmpelado());
            response.sendRedirect("./venta/separaAuto");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
