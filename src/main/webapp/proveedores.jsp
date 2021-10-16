<%@ page import="controlador.Conexion"%>
<%@ page import="modelo.ProveedorDTO" %>
<%@	page import="modelo.ProveedorDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión de Proveedores</title>
	<link rel="stylesheet" href="css/Proveedores.css">
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
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="#">Proveedores</a></li>
                <li><a href="productos.jsp">Productos</a></li>
                <li><a href="ventas.jsp">Ventas</a></li>
                <li><a href="reportes.jsp">Reportes</a></li>
            </ul>
        </nav>
    </header>
    <header>
        <fieldset class="field1">
            <form action="ServletGestionProveedor" method="post">
            	<%
            	if (request.getParameter("nit") == null) {
               	%>
            	<label for="">NIT:
            		<input type="text" name="nit">
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
                <label for="">Ciudad: 
                    <input type="text" name="ciudad">
                </label>
                <button type="submit" name="btnCrear">Crear</button>
                <% 
            	} else {
                %>
                <label for="">NIT:
            		<input type="text" name="nit" value="<%=request.getParameter("nit")%>" readonly="readonly">
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
                <label for="">Ciudad: 
                    <input type="text" name="ciudad" value="<%=request.getParameter("ciu")%>">
                </label>
                <button type="submit" name="btnModificar">Modificar</button>
                <button type="submit" name="btnEliminar">Eliminar</button> 
                <%
            	}
                %>
            </form>
        </fieldset>
        <fieldset class="field2">
            <form action="ServletGestionProveedor" method="post">
                <label for="">NIT: 
                    <input type="text" name="nitb">
                </label>
                <button type="submit" name="btnConsultar">Consultar</button>
            </form>
            <table class="tabla">
            	<thead>
                	<tr>
                    	<th>NIT</th>
                    	<th>Nombre</th>
                    	<th>Direccion</th>
                    	<th>Telefono</th>
                    	<th>Ciudad</th>
                	</tr>
                </thead>
                <tbody>
	                <%
	                ProveedorDAO prc = new ProveedorDAO();
	                if (request.getParameter("nit") == null) {
	                	
	                	ArrayList<ProveedorDTO> registro = prc.listadoProveedor();
	               		for(int i = 0; i < registro.size(); i++) {
	                	                	                		
	                		ProveedorDTO data = registro.get(i);
	                %>
                    <tr>
                        <td><%= data.getNitProveedor() %></td>
                        <td><%= data.getNombreProveedor() %></td>
                        <td><%= data.getDireccionProveedor() %></td>
                        <td><%= data.getTelefonoProveedor() %></td>
                        <td><%= data.getCiudadProveedor() %></td>
                    </tr>
                    <%
                    	}
	               	
	                } else {
	                	
					%>
					<tr>
						<td><%= request.getParameter("nit") %></td>
						<td><%= request.getParameter("nom") %></td>
						<td><%= request.getParameter("dir") %></td>
                        <td><%= request.getParameter("tel") %></td>
                        <td><%= request.getParameter("ciu") %></td>
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