/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets;

import com.udistrital.ConcesionarioUD.control.dao.ClienteDAO;
import com.udistrital.ConcesionarioUD.control.dao.ContactoDAO;
import com.udistrital.ConcesionarioUD.modelo.bean.Cliente;
import com.udistrital.ConcesionarioUD.modelo.bean.Contacto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "buscarCliente", urlPatterns = {"/buscarCliente"})
public class buscarCliente extends HttpServlet {

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
        
        response.setContentType( "text/html; charset=iso-8859-1" );
        PrintWriter out = response.getWriter();
                
        Cliente cliente;
        ArrayList <Contacto> contactos;
        
               
        ClienteDAO clienteDAO = new ClienteDAO();
        ContactoDAO contactoDAO = new ContactoDAO();
        HttpSession sesion = request.getSession();
        
        cliente = clienteDAO.buscarCliente(request.getParameter("cedula"));
        
        
        if(cliente != null){
            sesion.setAttribute("cliente", cliente);
            contactos = contactoDAO.obtenerContactos(request.getParameter("cedula"));
            System.out.println("Se encontro el cliente");
            out.write("<tr>");
            out.write("<th>"+cliente.getNombre()+" "+cliente.getApellido()+"</th>");
            out.write("<th>"+cliente.getCedula()+"</th>");
            out.write("<th>");
            if(contactos != null){
                for (Contacto contacto : contactos) {                            
                    //out.write(contacto.getIdTipoContacto());                    
                    out.write(contacto.getDescripcionContacto()+" - ");
                }
            }else{
                out.write("No tiene contactos actualmente");
            }
            out.write("</th>");
            out.write("</tr>");
            //out.write("s");
            //request.getRequestDispatcher("Web/CotizacionView.jsp").forward(request, response);            
            //response.sendRedirect("cotizacion");
        }else{
            out.write("n");
            System.out.println("No se encontro el cliente");
            //response.sendRedirect("cotizacion");
            //request.getRequestDispatcher("Web/CotizacionView.jsp").forward(request, response);
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
