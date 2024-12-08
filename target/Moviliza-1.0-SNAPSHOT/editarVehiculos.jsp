<%-- 
    Document   : editarVehiculos
    Created on : 7 dic 2024, 11:58:38 p.m.
    Author     : USER
--%>

<%@page import="logica.Automovil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Automovil auto = (Automovil) request.getSession().getAttribute("autoEditar"); %>
        <h1>Datos del Vehiculo</h1>
         <h1>Vehiculos</h1>
        <form action="SvEditar" method="POST">
            <p><label>Placa</label> <input type="text" name="placa" value="<%=auto.getPlaca()%>"></p>
            <button type="submit">Guardar</button>
        </form>
    </body>
</html>
