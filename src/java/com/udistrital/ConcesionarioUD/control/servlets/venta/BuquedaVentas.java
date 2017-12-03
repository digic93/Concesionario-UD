/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets.venta;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        switch(request.getParameter("busqueda")){
            case "cotizacionPorCCCliente":
                String result = cotizacionPorCCCliente(request.getParameter("valor"));
                
                //response.setContentType("application/json");
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
    
    private String cotizacionPorCCCliente(String parameter) {
        return "{\"result\":[{" +
            "\"clietne\": {" +
            "\"nombre\": \"Diego\"," +
            "\"apellido\": \"Castro Lopez\"" +
            "}," +
            "\"cotizacion\": {" +
            "\"idCotizacion\": 1," +
            "\"valor\": 72000000," +
            "\"fechaExpedicion\": \"2000/12/30\"," +
            "\"estado\": \"vigente\"" +
            "}," +
            "\"auto\": {" +
            "\"vin\": \"abcdefg\"," +
            "\"Marcar\": \"Mazda\"," +
            "\"Linea\": \"BT-50\"" +
            "}" +
            "}," +
            "{" +
            "\"clietne\": {" +
            "\"nombre\": \"Diego\"," +
            "\"apellido\": \"Castro Lopez\"" +
            "}," +
            "\"cotizacion\": {" +
            "\"idCotizacion\": 1," +
            "\"fechaExpedicion\": \"2000/12/30\"," +
            "\"valor\": 32000000," +
            "\"estado\": \"vigente\"" +
            "}," +
            "\"auto\": {" +
            "\"vin\": \"acd1231233\"," +
            "\"Marcar\": \"Hiunday\"," +
            "\"Linea\": \"i10\"" +
        "}}]}";
    }

}
