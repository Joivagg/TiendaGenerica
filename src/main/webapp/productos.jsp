<%@ page import="controlador.Conexion"%>
<%@ page import="modelo.ProductoDTO" %>
<%@	page import="modelo.ProductoDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Gestión de Productos</title>
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
        <!-- <label for="">
         	<input type="text" name="mensjae" value="${mensaje}" readonly="readonly">
        </label> -->
        <nav class="nav">
            <ul>
                <li><a href="usuarios.jsp">Usuarios</a></li>
                <li><a href="clientes.jsp">Clientes</a></li>
                <li><a href="proveedores.jsp">Proveedores</a></li>
                <li><a href="#">Productos</a></li>
                <li><a href="ventas.jsp">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
            </ul>
        </nav>
    </header>
    <header>
        <fieldset class="field1">
            <form action="ServletGestionProducto" method="post">
            	<%
            	if (request.getParameter("cod") == null) {
               	%>
            	<label for="">Código:
            		<input type="text" name="codigo">
            	</label>
                <label for="">Nombre: 
                    <input type="text" name="nombre">
                </label>
                <label for="">NIT Proveedor: 
                    <input type="text" name="nit">
                </label>
                <label for="">Precio Compra: 
                    <input type="text" name="preciob">
                </label>
                <label for="">IVA Compra:
                    <input type="text" name="iva">
                </label>
                <label for="">Precio Venta: 
                    <input type="text" name="precion">
                </label>
                <button type="submit" name="btnCrear">Crear</button>
                <button type="submit" name="btnCargar">Cargar</button>
                <% 
            	} else {
                %>
                <label for="">Código:
            		<input type="text" name="codigo" value="${producto.getCodigoProducto()}" readonly="readonly">
            	</label>
                <label for="">Nombre: 
                    <input type="text" name="nombre" value="${producto.getNombreProducto()}">
                </label>
                <label for="">NIT Proveedor: 
                    <input type="text" name="nit" value="${producto.getNitProveedor()}" readonly="readonly">
                </label>
                <label for="">Precio Compra: 
                    <input type="text" name="preciob" value="${producto.getPrecioCompra()}">
                </label>
                <label for="">IVA Compra:
                    <input type="text" name="iva" value="${producto.getIvaCompra()}">
                </label>
                <label for="">Precio Venta: 
                    <input type="text" name="precion" value="${producto.getPrecioVenta()}">
                </label>
                <button type="submit" name="btnModificar">Modificar</button>
                <button type="submit" name="btnEliminar">Eliminar</button>
                <%
            	}
                %>
            </form>
        </fieldset>
        <fieldset class="field2">
            <form action="ServletGestionProducto" method="post">
                <label for="">Código Producto: 
                    <input type="text" name="codigob">
                </label>
                <button type="submit" name="btnConsultar">Consultar</button>
            </form>
            <table class="tabla">
                <thead>
                	<tr>
                    	<th>Código</th>
                    	<th>Nombre</th>
                    	<th>Proveedor</th>
                    	<th>Precio</th>
                    	<th>IVA</th>
                    	<th>Total</th>
                	</tr>
                </thead>
                <tbody>
	                <%
	                ProductoDAO pro = new ProductoDAO();
	                if (request.getParameter("cod") == null) {
	                	
	                	ArrayList<ProductoDTO> registro = pro.listadoProducto();
	               		for(int i = 0; i < registro.size(); i++) {
	                	                	                		
	                		ProductoDTO data = registro.get(i);
	                %>
                    <tr>
                        <td><%= data.getCodigoProducto() %></td>
                        <td><%= data.getNombreProducto() %></td>
                        <td><%= data.getNitProveedor() %></td>
                        <td><%= data.getPrecioCompra() %></td>
                        <td><%= data.getIvaCompra() %></td>
                        <td><%= data.getPrecioVenta() %></td>
                    </tr>
                    <%
                    	}
	               	
	                } else {
	                	
					%>
					<tr>
						<td>${producto.getCodigoProducto()}</td>
						<td>${producto.getNombreProducto()}</td>
						<td>${producto.getNitProveedor()}</td>
                        <td>${producto.getPrecioCompra()}</td>
                        <td>${producto.getIvaCompra()}</td>
                        <td>${producto.getPrecioVenta()}</td>
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