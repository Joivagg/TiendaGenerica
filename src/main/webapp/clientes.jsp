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
                <li><a href="usuarios.jsp">Usuarios</a></li>
                <li><a href="#">Clientes</a></li>
                <li><a href="proveedores.jsp">Provedores</a></li>
                <li><a href="#">Productos</a></li>
                <li><a href="#">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
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
            		<input type="text" name="cedula" value="<%=request.getParameter("ced")%>" readonly="readonly">
            	</label>
                <label for="">Nombre Completo: 
                    <input type="text" name="nombre" value="<%=request.getParameter("nom")%>">
                </label>
                <label for="">Dirección: 
                    <input type="text" name="direccion" value="<%=request.getParameter("dir")%>">
                </label>
                <label for="">Teléfono: 
                    <input type="text" name="telefono" value="<%=request.getParameter("tel")%>">
                </label>
                <label for="">Correo Electrónico: 
                    <input type="email" name="email" value="<%=request.getParameter("ema")%>">
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
	                <%
	                ClienteDAO clc = new ClienteDAO();
	                if (request.getParameter("ced") == null) {
	                	
	                	ArrayList<ClienteDTO> registro = clc.listadoCliente();
	               		for(int i = 0; i < registro.size(); i++) {
	                	                	                		
	                		ClienteDTO data = registro.get(i);
	                %>
                    <tr>
                        <td><%= data.getCedulaCliente() %></td>
                        <td><%= data.getNombreCliente() %></td>
                        <td><%= data.getDireccionCliente() %></td>
                        <td><%= data.getTelefonoCliente() %></td>
                        <td><%= data.getEmailCliente() %></td>
                    </tr>
                    <%
                    	}
	               	
	                } else {
	                	
					%>
					<tr>
						<td><%= request.getParameter("ced") %></td>
						<td><%= request.getParameter("nom") %></td>
						<td><%= request.getParameter("dir") %></td>
                        <td><%= request.getParameter("tel") %></td>
                        <td><%= request.getParameter("ema") %></td>
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