/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.moviliza.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import logica.Automovil;
import logica.Controladora;

@WebServlet(name = "SvAutos", urlPatterns = {"/SvAutos"})
public class SvAutos extends HttpServlet {
Controladora control=new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         List<Automovil> listaVehiculos=new ArrayList<>();
        listaVehiculos=control.traerVehiculos();
        
        HttpSession misesion= request.getSession();
        misesion.setAttribute("listaAutomovil", listaVehiculos);
        
        response.sendRedirect("mostrarVehiculos.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
        String placa = request.getParameter("placa");

        Automovil auto = new Automovil();
        auto.setPlaca(placa);
        control.crearAutomovil(auto);

        // Redirige al usuario a una página de confirmación
        response.sendRedirect("index.jsp");
    } catch (Exception e) {
        // Manejo básico de errores
        response.getWriter().write("Ocurrió un error al guardar el vehículo: " + e.getMessage());
    }
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
