<%@ page import="controlador.Conexion"%>
<%@ page import="modelo.ClienteDTO" %>
<%@	page import="modelo.ClienteDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión de Clientes</title>
	<link rel="stylesheet" href="css/Clientes.css">
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	%>
	<header class="cont-header" id="cont-header">
    	<div class="logo-titulo" id="logo-titulo">
       		<h1 class="h1" id="h1">TIENDA GENERICA</h1>
            <div class="logo" id="logo"></div>
        </div>
        <nav class="nav">
            <ul>
            	<%
                if((String)hs.getAttribute("username") == null) {
                %>
                <li><a href="index.jsp">Usuarios</a></li>
                <li><a href="index.jsp">Clientes</a></li>
                <li><a href="index.jsp">Proveedores</a></li>
                <li><a href="index.jsp">Productos</a></li>
                <li><a href="index.jsp">Ventas</a></li>
                <li><a href="index.jsp">Reportes</a></li>
                <%
                } else {
                %>
                <li><a href="usuarios.jsp">Usuarios</a></li>
                <li><a href="#">Clientes</a></li>
                <li><a href="proveedores.jsp">Proveedores</a></li>
                <li><a href="productos.jsp">Productos</a></li>
                <li><a href="ventas.jsp">Ventas</a></li>
                <li><a href="reportes.jsp">Reportes</a></li>
                <%
                }
                %>
            </ul>
        </nav>
    </header>
    <header>
        <fieldset class="field1">
            <form action="ServletGestionCliente" method="post">
            	<%
            	if (request.getParameter("ced") == null) {
               	%>
            	<label for="">Cédula:
            		<input type="text" name="cedula">
            	</label>
                <label for="">Nombre Completo: 
                    <input type="text" name="nombre">
                </label>
                <label for="">Dirección: 
                    <input type="text" name="direccion">
                </label>
                <label for="">Teléfono: 
                    <input type="text" name="telefono">
                </label>
                <label for="">Correo Electrónico: 
                    <input type="email" name="email">
                </label>
                <button type="submit" name="btnCrear">Crear</button>
                <% 
            	} else {
                %>
                <label for="">Cédula:
            		<input type="text" name="cedula" value="${cliente.getCedulaCliente()}" readonly="readonly">
            	</label>
                <label for="">Nombre Completo: 
                    <input type="text" name="nombre" value="${cliente.getNombreCliente()}">
                </label>
                <label for="">Dirección: 
                    <input type="text" name="direccion" value="${cliente.getDireccionCliente()}">
                </label>
                <label for="">Teléfono: 
                    <input type="text" name="telefono" value="${cliente.getTelefonoCliente()}">
                </label>
                <label for="">Correo Electrónico: 
                    <input type="email" name="email" value="${cliente.getEmailCliente()}">
                </label>
                <button type="submit" name="btnModificar">Modificar</button>
                <button type="submit" name="btnEliminar">Eliminar</button> 
                <%
            	}
                %>
            </form>
        </fieldset>
        <fieldset class="field2">
            <form action="ServletGestionCliente" method="post">
                <label for="">Cédula: 
                    <input type="text" name="cedulab">
                </label>
                <button type="submit" name="btnConsultar">Consultar</button>
            </form>
            <%
	        ClienteDAO clc = new ClienteDAO();
	        if (request.getParameter("ced") != null) {
			%>
            <table class="tabla">
            	<thead>
                	<tr>
                    	<th>Cedula</th>
                    	<th>Nombre</th>
                    	<th>Direccion</th>
                    	<th>Telefono</th>
                    	<th>Correo</th>
                	</tr>
                </thead>
                <tbody>
					<tr>
						<td>${cliente.getCedulaCliente()}</td>
						<td>${cliente.getNombreCliente()}</td>
						<td>${cliente.getDireccionCliente()}</td>
                        <td>${cliente.getTelefonoCliente()}</td>
                        <td>${cliente.getEmailCliente()}</td>
                    </tr>
                </tbody>
            </table>
			<%
	        }
			%>
        </fieldset>
    </header>
</body>
</html>