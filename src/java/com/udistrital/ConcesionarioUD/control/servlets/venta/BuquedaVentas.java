/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets.venta;

import com.google.gson.Gson;
import com.udistrital.ConcesionarioUD.control.dao.CotizacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "BuquedaVentas", urlPatterns = {"/venta/busar"}, initParams = {
    @WebInitParam(name = "busqueda", value = "")
    , @WebInitParam(name = "valor", value = "")})
public class BuquedaVentas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String text)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BuquedaVentas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuquedaVentas at " + text + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        String result;
        switch(request.getParameter("busqueda")){
            case "cotizacionPorCCCliente":
                result = cotizacionPorCCCliente(request.getParameter("valor"));
                
                response.setContentType("application/json");
                //new Gson().toJson()
                response.getWriter().write(result);
                break;
            
            case "cotizacionAprobarCreditoPorCCCliente":
                result = cotizacionAprobarCreditoPorCCCliente(request.getParameter("valor"));
                
                response.setContentType("application/json");
                //new Gson().toJson()
                response.getWriter().write(result);
                break;
            default:
                //response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
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
    
    private String cotizacionPorCCCliente(String cedulaCliente) {
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        ArrayList<Map<String, Object>> cotizaciones = cotizacionDAO.buscarPorCedulaCliente(cedulaCliente);
        return new Gson().toJson(cotizaciones);
    }

    private String cotizacionAprobarCreditoPorCCCliente(String cedulaCliente) {
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        ArrayList<Map<String, Object>> cotizaciones = cotizacionDAO.cotizacionAprobarCreditoPorCCCliente(cedulaCliente);
        return new Gson().toJson(cotizaciones);
    }

}
