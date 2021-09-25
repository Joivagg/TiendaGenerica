<%@ page import="controlador.Conexion"%>
<%@ page import="modelo.Usuario" %>
<%@	page import="modelo.UsuarioCrud"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión de Usuarios</title>
	<link rel="stylesheet" href="css/Usuarios.css">
</head>
<body>
	<%
	Conexion con= new Conexion();
	con.conexiondb();
	%>
	<header class="cont-header" id="cont-header">
    	<div class="logo-titulo" id="logo-titulo">
    		<h1 class="h1" id="h1">TIENDA GENERICA</h1>
            <div class="logo" id="logo"></div>
        </div>
        <nav class="nav">
            <ul>
                <li><a href="#">Usuarios</a></li>
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="proveedores.jsp">Provedores</a></li>
                <li><a href="#">Productos</a></li>
                <li><a href="#">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
            </ul>
        </nav>
    </header>
    <header>
        <fieldset class="field1">
            <form action="ServletGestionUsuario" method="post">
            	<label for="">Cédula:
            		<input type="text" name="cedula">
            	</label>
                <label for="">Nombre Completo: 
                    <input type="text" name="nombre">
                </label>
                <label for="">Correo Electronico: 
                    <input type="email" name="email">
                </label>
                <label for="">Usuario: 
                    <input type="text" name="user">
                </label>
                <label for="">Contraseña: 
                    <input type="password" name="pass">
                </label>
                <button type="submit" name="btnCrear">Crear</button>
                <button type="submit" name="btnModificar">Modificar</button>
            </form>
        </fieldset>
        <fieldset class="field2">
            <form action="ServletGestionUsuario" method="post">
                <label for="">Cédula: 
                    <input type="text" name="cedulab">
                </label>
                <button type="submit" name="btnConsultar">Consultar</button>
                <button type="submit" name="btnEliminar">Eliminar</button> 
            </form>
            <table class="tabla">
                <thead>
                	<tr>
                    	<th>Cedula</th>
                    	<th>Nombre</th>
                    	<th>Correo</th>
                    	<th>Usuario</th>
                    	<th>Contraseña</th>
                	</tr>
                </thead>
                <tbody>
	                <%
	                	UsuarioCrud usu = new UsuarioCrud();
	                	ArrayList<Usuario> registro = usu.listadoUsuario(request.getParameter("cedulab"));
	                	for(int i = 0; i < registro.size(); i++) {
	                		
	                		Usuario data = registro.get(i);
	                %>
                    <tr>
                        <td><%= data.getCedula_usuario() %></td>
                        <td><%= data.getNombre_usuario() %></td>
                        <td><%= data.getEmail_usuario() %></td>
                        <td><%= data.getUsuario() %></td>
                        <td><%= data.getPassword() %></td>
                    </tr>
                    <%
                    	}
                    %>
                </tbody>
            </table>
        </fieldset>
    </header>
</body>
</html>