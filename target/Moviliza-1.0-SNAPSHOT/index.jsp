<%-- 
    Document   : index
    Created on : 5 dic 2024, 9:08:25 p.m.
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vehiculos</h1>
        <form action="SvAutos" method="POST">
            <p><label>Placa</label> <input type="text" name="placa"></p>
            <button type="submit">Enviar</button>
        </form>
        
        <h1>Lista de Vehiculos</h1>
        <form action="SvAutos" method="GET">
            <p><label>Cick para ver la lista</label></p>
            <button type="submit">Ver lista</button>
        </form>
        
        <h1>Eliminar vehiculo</h1>
        <p>Ingrese el id del vehiculo a eliminar</p>
        <form action="SvEliminar" method="POST">
            <p><label>Id: </label> <input type="text" name="id_automovil"></p>
            <button type="submit">Eliminar vehiculo</button>
        </form>
        
        <h1>Editar vehiculo</h1>
        <p>Ingrese el id del vehiculo a editar</p>
        <form action="SvEditar" method="GET">
            <p><label>Id: </label> <input type="text" name="id_automovilEdit"></p>
            <button type="submit">Editar vehiculo</button>
        </form>
        
    </body>
</html>
