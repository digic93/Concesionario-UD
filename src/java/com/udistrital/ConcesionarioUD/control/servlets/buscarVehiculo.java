/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets;

import com.udistrital.ConcesionarioUD.control.dao.AutoCaracteristicaDAO;
import com.udistrital.ConcesionarioUD.control.dao.AutoDAO;
import com.udistrital.ConcesionarioUD.control.dao.CaracteristicaDAO;
import com.udistrital.ConcesionarioUD.control.dao.TipoCaracteristicaDAO;

import com.udistrital.ConcesionarioUD.modelo.bean.AutoCaracteristica;
import com.udistrital.ConcesionarioUD.modelo.bean.Caracteristica;
import com.udistrital.ConcesionarioUD.modelo.bean.TipoCaracteristica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiag
 */
@WebServlet(name = "buscarVehiculo", urlPatterns = {"/buscarVehiculo"})
public class buscarVehiculo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Web/CotizacionView.jsp").forward(request, response);

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
        ArrayList <AutoCaracteristica> autoCaracteristica;
        ArrayList <TipoCaracteristica> tipoCaracteristicas;
        ArrayList <Caracteristica> caracteristicas;
        AutoCaracteristicaDAO autoCaracteristicasDAO = new AutoCaracteristicaDAO();
        TipoCaracteristicaDAO tipoCDAO = new TipoCaracteristicaDAO();
        CaracteristicaDAO caracteristicaDAO = new CaracteristicaDAO();
        
        PrintWriter out = response.getWriter();
        tipoCaracteristicas = tipoCDAO.cargarCaracteristicas();
        
        
        autoCaracteristica = autoCaracteristicasDAO.consultarIDforVIN(request.getParameter("vin"));        
        caracteristicas = caracteristicaDAO.obtenerCaracteristicas(request.getParameter("vin"));
       
       
        if(caracteristicas!=null){
            
            for (int i = 0; i<tipoCaracteristicas.size(); i++) {
                out.write("<tr>");
                    //System.out.println(tipoCaracteristica.getIdTipoCaracteristica()+" - "+tipoCaracteristica.getNombre());
                    out.write("<th>"+tipoCaracteristicas.get(i).getIdTipoCaracteristica()+"</th>");
                    out.write("<th>"+tipoCaracteristicas.get(i).getNombre()+"</th>");
                    out.write("<th>"+caracteristicas.get(i).getNombre()+"</th>");
                out.write("</tr>");
            }

            
        }else{
            out.write("n");
            System.out.println("No se encontro el vehiculo");
        }
        
        
        
//        request.getRequestDispatcher("Web/CotizacionView.jsp").forward(request, response);     
        
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
