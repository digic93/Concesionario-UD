/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets;

import com.udistrital.ConcesionarioUD.control.dao.HistoricoPrecioParteDAO;
import com.udistrital.ConcesionarioUD.control.dao.ParteDAO;
import com.udistrital.ConcesionarioUD.modelo.bean.HistoricoPrecioParte;
import com.udistrital.ConcesionarioUD.modelo.bean.Parte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiag
 */
@WebServlet(name = "buscarParte", urlPatterns = {"/buscarParte"})
public class buscarParte extends HttpServlet {

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
        //System.out.println("Buscando partes...");
        ArrayList <Parte> partes;
        ArrayList <HistoricoPrecioParte> precios;
        ParteDAO parteDAO = new ParteDAO();
        HistoricoPrecioParteDAO preciosDAO = new HistoricoPrecioParteDAO();
        
        PrintWriter out = response.getWriter();
        
        partes = parteDAO.consultarPartes();
        precios = preciosDAO.obtenerPrecios();
        
        if(partes != null){
            int i = 0;
            for (Parte parte : partes) {
                i++;
                out.write("<tr>");
                    out.write("<th>("+i+")</th>");//numero
                switch (parte.getIdTipoParte()) {
                    case 1:
                        out.write("<th>Tramite</th>");//tipo caracteristica
                        break;
                    case 2:
                        out.write("<th>Lujo</th>");//tipo caracteristica
                        break;
                    default:
                        out.write("<th>Sin costo</th>");//tipo caracteristica
                        break;
                }                          
                    
                    out.write("<th>"+parte.getNombre()+"</th>");//nombre
                    for (HistoricoPrecioParte precio : precios) {
                        
                        if(precio.getIdParte()==parte.getIdParte()){
                            out.write("<th>COP $"+precio.getPrecioParte()+"</th>");//precio
                        }
                    }
                    out.write("<th><center><input type='checkbox' value='"+parte.getIdParte()+"'></center></th>");//check

                out.write("</tr>");                
            }
        }else{
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
