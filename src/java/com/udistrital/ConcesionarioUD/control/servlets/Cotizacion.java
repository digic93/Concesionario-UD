/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets;

import com.udistrital.ConcesionarioUD.control.dao.CotizacionDAO;
import com.udistrital.ConcesionarioUD.control.dao.EmpleadoDAO;
import com.udistrital.ConcesionarioUD.control.dao.ParteAutoDAO;
import com.udistrital.ConcesionarioUD.control.dao.ProcesoDAO;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santiag
 */
@WebServlet(name = "Cotizacion", urlPatterns = {"/cotizacion"})
public class Cotizacion extends HttpServlet {


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
        request.getRequestDispatcher("Web/CotizacionView.jsp").forward(request, response);
        
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
        HttpSession sesion = request.getSession();
        PrintWriter out = response.getWriter();
        String[] partes = request.getParameterValues("partes[]");

        String cedula = request.getParameter("cedula");
        String vin = request.getParameter("vin");
        Empleado empleado = (Empleado)sesion.getAttribute("empleado");
        
        CotizacionDAO cotizacionDAO = new CotizacionDAO();
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        ProcesoDAO procesoDAO = new ProcesoDAO();
        ParteAutoDAO parteAutoDAO = new ParteAutoDAO();
        
        long totalPartes = (Long)cotizacionDAO.obtenerTotalPartes(partes);
        long totalAuto = (Long)cotizacionDAO.obtenerTotalAuto(vin);
        long total = totalPartes + totalAuto;
        
        int respuesta = cotizacionDAO.guardarCotizacion(cedula,empleado.getIdEmpelado(),total);      
             
        
        if(respuesta==1){//cotizacion registrada -> se guarda el proceso se guarda precios
            int numCotizacion = cotizacionDAO.obtenerCotizacion();
            respuesta = parteAutoDAO.guardar(partes,vin);
            if(respuesta == 1){
                respuesta = procesoDAO.guardar(empleado.getIdEmpelado(),numCotizacion);
                if(respuesta == 1){
                    out.write("<h4>Total Costo Vehiculo: $ "+totalAuto+" COP Total Costo Partes: $ "+totalPartes+" COP</h4>");
                    out.write("<h2>Total Cotizacion: $"+total+" COP</h2>");
                    out.write("<br><br>");
                    out.write("<input id=\"pdf\" type=\"button\" class=\"btn btn-success btn-xs\" value=\"Generar PDF\"/>");        
                    out.write("<br><br>");
                    out.write("<br><br>");                   
                }else{//fallo en guardar proceso
                    out.write("n");
                }   
            }else{//fallo en guardar parte Auto
                out.write("n");
            }
            
        }else{// fallo en guardar cotizacion
           out.write("n");
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
