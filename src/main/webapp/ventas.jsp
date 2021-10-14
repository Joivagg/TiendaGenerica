<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.ReporteDTO" %>
<%@ page import="modelo.VentaDTO" %>
<%@	page import="modelo.ProductoDAO" %>
<%@ page import="modelo.ProductoDTO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/Ventas.css">
    <title>TIENDA GENERICA</title>
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	ProductoDAO prc = new ProductoDAO();
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
                <li><a href="proveedores.jsp">Provedores</a></li>
                <li><a href="productos.jsp">Productos</a></li>
                <li><a href="#">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
            </ul>
        </nav>
    </header>
    <header class="contenido1">
		<fieldset class="field1">
        	<form action="ServletGestionVentas" method="post">
                <%
            	if (request.getParameter("cedCli") == null) {
               	%>
            	<label for="" class="l1">Cédula Cliente: 
                	<input type="text" name="ccliente">
                </label>
                <button type="submit" name="btnConsultarCliente">Consultar</button>
                <%
            	} else {
                %>
        		<label for="" class="l1">Usuario:
                	<input type="text" name="user" value="${username}" readonly="readonly">
                </label>
                <label for="" class="l1">Cliente: 
                	<input type="text" name="ncliente" value="${cliente.getNombreCliente()}" readonly="readonly">
                </label>
                <label for="" class="l1">Código Venta: 
                	<input type="text" name="codventa" value="${codVenta}" readonly="readonly">
                </label>
                <%
            	}
                %>
            </form>
        </fieldset>
        <fieldset class="field2">
        	<%
        	if (request.getParameter("cedCli") != null) {
        	%>
        	<form action="ServletGestionVentas" method="post" class="form1">
            	<label for="" class="l1">Cod. Producto: 
                	<input type="text" name="codproducto">
                </label>
                <label for="" class="l1">Cantidad:
                	<input type="text" name="canproducto">
                </label>
                <button type="submit" name="btnAgregarProducto">Agregar</button>
            </form>
            <%
            	if (!(Boolean)hs.getAttribute("isEmpty")) {
            %>
            <form>
            	<table>
                	<thead>
                    	<tr>
                    		<th>Orden</th>
                        	<th>Producto</th>
                            <th>Cantidad</th>
                            <th>Valor Unitario</th>
                            <th>IVA</th>
                            <th>Valor Total</th>
                		</tr>
                    </thead>
                    <tbody>
                    	<%
                    	ArrayList<?> canastaProductos = (ArrayList<?>)hs.getAttribute("datosVenta");
                    	for (int i = 0; i < canastaProductos.size(); i++) {
                    		ReporteDTO re = (ReporteDTO)canastaProductos.get(i);
                    		if(prc.verificarProducto(Integer.toString(re.getCodigoProducto()))) {
                    			
                    			ProductoDTO pr = prc.consultarProducto();
                    	%>
                    	<tr>
                    		<td><%= i + 1 %></td>
                        	<td><%= pr.getNombreProducto() %></td>
                            <td><%= re.getCantidadProducto() %></td>
                            <td><%= (int)re.getValorVenta() %></td>
                            <td><%= (int)re.getValorIva() %></td>
                            <td><%= (int)re.getValorTotal() %></td>
                        </tr>
                        <%
                    		}
                    	}
                        %>
                    </tbody>
                </table>
            </form> 
        	<%
            	}
        	}
        	%>
        </fieldset>
        <fieldset class="field3">
        	<%
        	if (request.getParameter("cedCli") != null && !(Boolean)hs.getAttribute("isEmpty")) {
        	%>
            <form action="ServletGestionVentas" method="post" class="f3c2">
                <table>
                    <tbody>
                    	<%
                    	VentaDTO ve = (VentaDTO)hs.getAttribute("infoVenta");
                    	%>
                        <tr>
                          	<th>Total Venta</th>
                            <td><%= (int)ve.getValorVenta() %></td>
                        </tr>
                        <tr>
                            <th>Total IVA</th>
                            <td><%= (int)ve.getIvaVenta() %></td>
                        </tr>
						<tr>
                            <th>Total con IVA</th>
							<td><%= (int)ve.getTotalVenta() %></td>
						</tr>
					</tbody>
				</table>
				<button type="submit" name="btnSubirVenta">Subir</button>
			</form>
			<%
        	}
			%>
		</fieldset>
    </header>
</body>
</html>