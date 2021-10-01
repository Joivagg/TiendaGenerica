<%@ page import="controlador.Conexion"%>
<%@	page import="modelo.ProductoDAO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Productos</title>
	<link rel="stylesheet" href="css/Productos.css">
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
                <li><a href="proveedores.jsp">Proveedores</a></li>
                <li><a href="#">Productos</a></li>
                <li><a href="#">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
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