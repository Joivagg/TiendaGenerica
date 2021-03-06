<%@ page import="controlador.Conexion"%>
<%@ page import="modelo.UsuarioDTO" %>
<%@	page import="modelo.UsuarioDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gesti?n de Usuarios</title>
	<link rel="stylesheet" href="css/Usuarios.css">
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
                <li><a href="#">Usuarios</a></li>
                <li><a href="clientes.jsp">Clientes</a></li>
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
            <form action="ServletGestionUsuario" method="post">
            	<%
            	if (request.getParameter("ced") == null) {
               	%>
            	<label for="">C?dula:
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
                <label for="">Contrase?a: 
                    <input type="password" name="pass">
                </label>
                <button type="submit" name="btnCrear">Crear</button>
                <% 
            	} else {
                %>
                <label for="">C?dula:
            		<input type="text" name="cedula" value="${usuario.getCedula_usuario()}" readonly="readonly">
            	</label>
                <label for="">Nombre Completo: 
                    <input type="text" name="nombre" value="${usuario.getNombre_usuario()}">
                </label>
                <label for="">Correo Electronico: 
                    <input type="email" name="email" value="${usuario.getEmail_usuario()}">
                </label>
                <label for="">Usuario: 
                    <input type="text" name="user" value="${usuario.getUsuario()}">
                </label>
                <label for="">Contrase?a: 
                    <input type="password" name="pass" value="${usuario.getPassword()}">
                </label>
                <button type="submit" name="btnModificar">Modificar</button>
                <button type="submit" name="btnEliminar">Eliminar</button> 
                <%
            	}
                %>
            </form>
        </fieldset>
        <fieldset class="field2">
            <form action="ServletGestionUsuario" method="post">
                <label for="">C?dula: 
                    <input type="text" name="cedulab">
                </label>
                <button type="submit" name="btnConsultar">Consultar</button>
            </form>
            <%
            UsuarioDAO usu = new UsuarioDAO();
            if (request.getParameter("ced") != null) {
			%>
            <table class="tabla">
                <thead>
                	<tr>
                    	<th>Cedula</th>
                    	<th>Nombre</th>
                    	<th>Correo</th>
                    	<th>Usuario</th>
                	</tr>
                </thead>
                <tbody>
					<tr>
						<td>${usuario.getCedula_usuario()}</td>
						<td>${usuario.getNombre_usuario()}</td>
						<td>${usuario.getEmail_usuario()}</td>
                        <td>${usuario.getUsuario()}</td>
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