<%-- 
    Document   : mostrarVehiculos
    Created on : 6 dic 2024, 1:04:57 a.m.
    Author     : USER
--%>

<%@page import="java.util.List"%>
<%@page import="logica.Automovil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Vehiculos</title>
    </head>
    <body>
        <h1>Lista de Vehiculos</h1>
        <%
            List<Automovil> listaAutomovil = (List) request.getSession().getAttribute("listaAutomovil");
            int cont=1;
            for(Automovil auto:listaAutomovil){
        %>
        
            <p><b> Vehiculo N° <%=cont%></b></p>
            <p>Id: <%=auto.getId()%></p>
            <p>Placa: <%=auto.getPlaca()%></p>
            <% cont=cont +1 ;%>
            
        <%}%>
    </body>
</html>
