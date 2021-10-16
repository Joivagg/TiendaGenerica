<%@ page import="modelo.ClienteDTO" %>
<%@	page import="modelo.ClienteDAO" %>
<%@ page import="modelo.UsuarioDTO" %>
<%@	page import="modelo.UsuarioDAO" %>
<%@ page import="modelo.ProveedorDTO" %>
<%@	page import="modelo.ProveedorDAO" %>
<%@ page import="modelo.ProductoDTO" %>
<%@	page import="modelo.ProductoDAO" %>
<%@ page import="modelo.VentaDTO" %>
<%@ page import="modelo.VentaDAO" %>
<%@ page import="modelo.ReporteDTO" %>
<%@ page import="modelo.ReporteDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Reportes</title>
	<link rel="stylesheet" href="css/Reportes.css">
</head>
<body>
	<%
	HttpSession hs = request.getSession();
	String seleccionarRegistro = (String)request.getParameter("tabla");
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
                <li><a href="productos.jsp">Productos</a></li>
                <li><a href="ventas.jsp">Ventas</a></li>
                <li><a href="#">Reportes</a></li>
            </ul>
        </nav>
    </header>
    <header>
    	<fieldset class="contenedor">
    		<form action="ServletGestionReporte" method="post">
    			<%
    			if(seleccionarRegistro == null) {
    			%>
    			<label for="">Seleccione el reporte que desea ver:</label>
	        	<label for="">
	        		<button type="submit" name="mostrarUsuarios">Usuarios</button>
	        	</label>
	        	<label for="">
	        		<button type="submit" name="mostrarClientes">Clientes</button>
	        	</label>
	        	<label for="">
	        		<button type="submit" name="mostrarProveedores">Proveedores</button>
	        	</label>
	        	<label for="">
	        		<button type="submit" name="mostrarProductos">Productos</button>
	        	</label>
	        	<label for="">
	        		<button type="submit" name="mostrarVentas">Ventas</button>
	        	</label>
    			<%
    			} else if(seleccionarRegistro.equals("usuarios")) {
    			%>
    			<table>
	            	<thead>
	                	<tr>
	                    	<th>Cédula</th>
	                    	<th>Nombre</th>
	                    	<th>Correo</th>
	                    	<th>Usuario</th>
	                	</tr>
	                </thead>
	                <tbody>
		                <%
						UsuarioDAO usc = new UsuarioDAO();
		               	ArrayList<UsuarioDTO> tablaUsuario = usc.listadoUsuario();
	            		for(int i = 0; i < tablaUsuario.size(); i++) {
		                	                	                		
		                	UsuarioDTO us = tablaUsuario.get(i);
		                %>
	                    <tr>
	                        <td><%= us.getCedula_usuario() %></td>
	                        <td><%= us.getNombre_usuario() %></td>
	                        <td><%= us.getEmail_usuario() %></td>
	                        <td><%= us.getUsuario() %></td>
	                    </tr>
						<%
		                }
						%>
	                </tbody>
	            </table>
	            <button type="submit" name="regresar">Volver</button>
    			<%
    			} else if(seleccionarRegistro.equals("clientes")) {
    	    	%>
    	    	<table>
	            	<thead>
	                	<tr>
	                    	<th>Cédula</th>
	                    	<th>Nombre</th>
	                    	<th>Dirección</th>
	                    	<th>Teléfono</th>
	                    	<th>Correo</th>
	                	</tr>
	                </thead>
	                <tbody>
		                <%
						ClienteDAO clc = new ClienteDAO();
		                ArrayList<ClienteDTO> tablaCliente = clc.listadoCliente();
		               	for(int i = 0; i < tablaCliente.size(); i++) {
		                	                	                		
		                	ClienteDTO cl = tablaCliente.get(i);
		                %>
	                    <tr>
	                        <td><%= cl.getCedulaCliente() %></td>
	                        <td><%= cl.getNombreCliente() %></td>
	                        <td><%= cl.getDireccionCliente() %></td>
	                        <td><%= cl.getTelefonoCliente() %></td>
	                        <td><%= cl.getEmailCliente() %></td>
	                    </tr>
						<%
		                }
						%>
	                </tbody>
	            </table>
	            <button type="submit" name="regresar">Volver</button>
    	    	<%
    			} else if(seleccionarRegistro.equals("proveedores")) {
    			%>
    			<table>
	            	<thead>
	                	<tr>
	                    	<th>NIT</th>
	                    	<th>Nombre</th>
	                    	<th>Dirección</th>
	                    	<th>Teléfono</th>
	                    	<th>Ciudad</th>
	                	</tr>
	                </thead>
	                <tbody>
		                <%
						ProveedorDAO prvc = new ProveedorDAO();
		                ArrayList<ProveedorDTO> tablaProveedor = prvc.listadoProveedor();
		               	for(int i = 0; i < tablaProveedor.size(); i++) {
		               		
		                	ProveedorDTO prv = tablaProveedor.get(i);
		                %>
	                    <tr>
	                        <td><%= prv.getNitProveedor() %></td>
	                        <td><%= prv.getNombreProveedor() %></td>
	                        <td><%= prv.getDireccionProveedor() %></td>
	                        <td><%= prv.getTelefonoProveedor() %></td>
	                        <td><%= prv.getCiudadProveedor() %></td>
	                    </tr>
						<%
		                }
						%>
	                </tbody>
	            </table>
	            <button type="submit" name="regresar">Volver</button>
    			<%
    			} else if(seleccionarRegistro.equals("productos")) {
    			%>
    			<table>
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
						ProductoDAO prdc = new ProductoDAO();
						ProveedorDAO prvc = new ProveedorDAO();
		                ArrayList<ProductoDTO> tablaProducto = prdc.listadoProducto();
		               	for(int i = 0; i < tablaProducto.size(); i++) {
		               		
		                	ProductoDTO prd = tablaProducto.get(i);
		                	ProveedorDTO prv = prvc.consultarProveedor(prd.getNitProveedor());
	
		                %>
	                    <tr>
	                        <td><%= prd.getCodigoProducto() %></td>
	                        <td><%= prd.getNombreProducto() %></td>
	                        <td><%= prv.getNombreProveedor() %></td>
	                        <td>$<%= (int)prd.getPrecioCompra() %></td>
	                        <td><%= (int)prd.getIvaCompra() %>%</td>
	                        <td>$<%= (int)prd.getPrecioVenta() %></td>
	                    </tr>
						<%
		                }
						%>
	                </tbody>
	            </table>
	            <button type="submit" name="regresar">Volver</button>
    			<%
    			} else if(seleccionarRegistro.equals("ventas")) {
    			%>
    			<table>
	               	<thead>
	                   	<tr>
	                   		<th>Código</th>
	                       	<th>Cliente</th>
	                        <th>Usuario</th>
	                        <th>Valor Venta</th>
	                        <th>IVA</th>
	                        <th>Valor Total</th>
	                        <th>Detalles</th>
	               		</tr>
			        </thead>
			        <tbody>
			        	<%
						VentaDAO vec = new VentaDAO();
						ClienteDAO clc = new ClienteDAO();
						UsuarioDAO usc = new UsuarioDAO();
		                ArrayList<VentaDTO> tablaVenta = vec.listadoVenta();
		               	for(int i = 0; i < tablaVenta.size(); i++) {
		               		
		                	VentaDTO ve = tablaVenta.get(i);
		                	ClienteDTO cl = clc.consultarCliente(ve.getCedulaCliente());
		                	UsuarioDTO us = usc.consultarUsuario(ve.getCedulaUsuario());
			        	%>
			        	<tr>
			        		<td><%= ve.getCodigoVenta() %></td>
	                        <td><%= cl.getNombreCliente() %></td>
	                        <td><%= us.getNombre_usuario() %></td>
	                        <td>$<%= (int)ve.getValorVenta() %></td>
	                        <td>$<%= (int)ve.getIvaVenta() %></td>
	                        <td>$<%= (int)ve.getTotalVenta() %></td>
	                        <td><button type="submit" name="mostrarDetalles" value="<%= ve.getCodigoVenta() %>">Ver</button></td>
			            </tr>
			            <%
		               	}
			            %>
		            </tbody>
		        </table>
		        <button type="submit" name="regresar">Volver</button>
    			<%
    			} else if(seleccionarRegistro.equals("reportes")) {
    			%>
    			<table>
					<thead>
	                   	<tr>
	                   		<th>Código Venta</th>
	                       	<th>Producto</th>
	                        <th>Cantidad</th>
	                        <th>Precio Bruto</th>
	                        <th>IVA</th>
	                        <th>Precio Neto</th>
	               		</tr>
			        </thead>
					<tbody>
	                   	<%
						ReporteDAO rec = new ReporteDAO();
						ProductoDAO prdc = new ProductoDAO();
		                ArrayList<ReporteDTO> tablaDetalle = rec.listadoReporte(Integer.parseInt((String)hs.getAttribute("venta")));
		               	for(int i = 0; i < tablaDetalle.size(); i++) {
		               		
		                	ReporteDTO re = tablaDetalle.get(i);
		                	ProductoDTO pr = prdc.consultarProducto(re.getCodigoProducto());
			        	%>
			        	<tr>
			        		<td><%= re.getCodigoVenta() %></td>
	                        <td><%= pr.getNombreProducto() %></td>
	                        <td><%= re.getCantidadProducto() %></td>
	                        <td>$<%= (int)re.getValorVenta() %></td>
	                        <td>$<%= (int)re.getValorIva() %></td>
	                        <td>$<%= (int)re.getValorTotal() %></td>
			            </tr>
			            <%
			        	}
			            %>
					</tbody>
				</table>
				<button type="submit" name="regresarVenta">Volver</button>
    			<%
    			}
    			%>
    		</form>
        </fieldset>
	</header>
</body>
</html>