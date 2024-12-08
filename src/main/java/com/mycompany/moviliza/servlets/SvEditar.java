package com.mycompany.moviliza.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.Automovil;
import logica.Controladora;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {
    Controladora control=new Controladora();


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_editar = Integer.parseInt(request.getParameter("id_automovilEdit")) ;
        Automovil auto = control.traerVehiculo(id_editar);
        
        HttpSession misesion= request.getSession();
        misesion.setAttribute("autoEditar", auto);
        
        response.sendRedirect("editarVehiculos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String placa = request.getParameter("placa");

        Automovil auto = (Automovil) request.getSession().getAttribute("autoEditar");
        auto.setPlaca(placa);
        control.editarAutomovil(auto);
        
        response.sendRedirect("index.jsp");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
