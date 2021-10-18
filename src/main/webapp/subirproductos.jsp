<%@ page import="controlador.Conexion"%>
<%@	page import="modelo.ProductoDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cargar Productos</title>
	<link rel="stylesheet" href="css/ProductosSubir.css">
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
        <!-- <label for="">
         	<input type="text" name="codigo" value="${mensaje}" readonly="readonly">
        </label> -->
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
    <header class="contenido1">
        <fieldset class="field2">
            <form action="Producto" method="post" enctype="multipart/form-data">
                <input type="file" name="archivo" value="">
                <input type="submit" name="cargar" value="add Archivo">
            </form>
        </fieldset>
    </header>
</body>
</html>