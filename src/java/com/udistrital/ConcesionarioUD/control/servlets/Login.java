/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udistrital.ConcesionarioUD.control.servlets;

import com.udistrital.ConcesionarioUD.control.dao.AutoDAO;
import com.udistrital.ConcesionarioUD.control.dao.EmpleadoDAO;
import com.udistrital.ConcesionarioUD.control.dao.HistoricoAccionesDAO;
import com.udistrital.ConcesionarioUD.modelo.bean.Empleado;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diego Castro
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {


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
        request.getRequestDispatcher("Web/LoginView.jsp").forward(request, response);
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
        Empleado empleado;
        ArrayList vehiculos;
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        HttpSession sesion = request.getSession();
        
        empleado = empleadoDAO.login(request.getParameter("usuario"), request.getParameter("password"));
        
        if (empleado != null) {
            sesion.setAttribute("empleado", empleado);  
            
            //request.setAttribute("error", "Usuario y Contraseña Correctos");
            actualizarAccion(empleado);
            vehiculos = cargarAutos();
            if(vehiculos != null){
               sesion.setAttribute("vehiculos", vehiculos);   
            }
            System.out.println("Sesion iniciada: "+empleado.getNombre()+" "+empleado.getApellido());            
            response.sendRedirect("cotizacion");
            
        } else {
            System.out.println("No se inicio sesión");
            request.setAttribute("error", "Usuario o Contraseña Incorrectos");
            request.getRequestDispatcher("Web/LoginView.jsp").forward(request, response);
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

    private void actualizarAccion(Empleado empleado) {
       HistoricoAccionesDAO hAcciones = new HistoricoAccionesDAO();
       hAcciones.accionLogin(empleado);
    }

    private ArrayList cargarAutos() {
        ArrayList vehiculos;
        AutoDAO autoDAO = new AutoDAO();
        vehiculos = autoDAO.cargar();
        return vehiculos;
        
    }

}
