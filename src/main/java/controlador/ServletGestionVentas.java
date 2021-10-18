package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.ReporteDAO;
import modelo.ReporteDTO;
import modelo.VentaDAO;
import modelo.VentaDTO;

/**
 * Servlet implementation class ServletGestionVentas
 */
@WebServlet("/ServletGestionVentas")
public class ServletGestionVentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionVentas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ced_Cli, cod_Pro, codDetVen;
		int codVen, cedCli, cedUsu, canPro, codPro;
		double valVenSum, valIvaSum, valTotSum, valVenRep, valIvaRep, valTotRep;
		HttpSession hs = request.getSession();
		ArrayList<ReporteDTO> canastaProductos = new ArrayList<ReporteDTO>();
		
		if (request.getParameter("btnConsultarCliente") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				cedUsu = (int)hs.getAttribute("cedUsuario");
				ced_Cli = request.getParameter("ccliente");
				ClienteDAO clc = new ClienteDAO();
				if (ced_Cli.isBlank()) {
					
					response.sendRedirect("ventas.jsp");					
									
				} else {
					
					if (!clc.verificarCliente(ced_Cli)) {
						
						//JOptionPane.showMessageDialog(null, "El cliente no está registrado");
						response.sendRedirect("ventas.jsp");
						
					} else {
					
						ClienteDTO cl = clc.consultarCliente(Integer.parseInt(ced_Cli));
						VentaDAO vec = new VentaDAO();
						ArrayList<VentaDTO> ventas = vec.listadoVenta();
						
						hs.setAttribute("cliente", cl);
						if (ventas.size() == 0) {
							
							hs.setAttribute("codVenta", 1);
							
						} else {
							
							VentaDTO ve = ventas.get(ventas.size() - 1);
							hs.setAttribute("codVenta", ve.getCodigoVenta() + 1);
							
						}
						codVen = (Integer)hs.getAttribute("codVenta");
						cedCli = Integer.parseInt(ced_Cli);
						valVenSum = 0;
						valIvaSum = 0;
						valTotSum = 0;
						hs.setAttribute("infoVenta", new VentaDTO(codVen, cedCli, cedUsu, valVenSum, valIvaSum, valTotSum));
						hs.setAttribute("cedCliente", cedCli);
						hs.setAttribute("isEmpty", true);
						hs.setAttribute("datosVenta", null);
						response.sendRedirect("ventas.jsp?cedCli=" + (int)hs.getAttribute("cedCliente"));
					
					}
					
				}
			
			}
			
		}
		
		if (request.getParameter("btnAgregarProducto") != null) {
			
			if(hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				cedUsu = (int)hs.getAttribute("cedUsuario");
				cod_Pro = request.getParameter("codproducto");
				ProductoDAO prc = new ProductoDAO();
				ReporteDAO rec = new ReporteDAO();
				if(cod_Pro.isBlank()) {
					
					response.sendRedirect("ventas.jsp?cedCli=" + request.getParameter("ccliente"));
					
				} else {
					
					if(!prc.verificarProducto(cod_Pro)) {
						
						//JOptionPane.showMessageDialog(null, "El producto no está registrado");
						response.sendRedirect("ventas.jsp?cedCli=" + request.getParameter("ccliente"));
						
					} else {
						
						if(rec.verificarReporte(Integer.toString((Integer)hs.getAttribute("codVenta")) + "-" + cod_Pro)) {
							
							//JOptionPane.showMessageDialog(null, "El producto ya fue registrado para la venta");
							response.sendRedirect("ventas.jsp?cedCli=" + request.getParameter("ccliente"));
							
						} else {
						
							if (hs.getAttribute("datosVenta") != null) {
								
								ArrayList<?> canastaTemporal = (ArrayList<?>)hs.getAttribute("datosVenta");
								for (int i = 0; i < canastaTemporal.size(); i++) {
									
									canastaProductos.add((ReporteDTO)canastaTemporal.get(i));
									
								}
								
							}
							ProductoDTO pr = prc.consultarProducto(Integer.parseInt(cod_Pro));
							codDetVen = Integer.toString((Integer)hs.getAttribute("codVenta")) + "." + cod_Pro;
							canPro = Integer.parseInt(request.getParameter("canproducto"));
							codPro = Integer.parseInt(cod_Pro);
							codVen = (Integer)hs.getAttribute("codVenta");
							valVenRep = (Double)pr.getPrecioVenta() * canPro;
							valIvaRep = valVenRep * (pr.getIvaCompra() / 100);
							valTotRep = valVenRep + valIvaRep;
							canastaProductos.add(new ReporteDTO(codDetVen, canPro, codPro, codVen, valVenRep, valIvaRep, valTotRep));
							hs.setAttribute("datosVenta", canastaProductos);
							VentaDTO ve = (VentaDTO)hs.getAttribute("infoVenta");
							cedCli = (Integer)hs.getAttribute("cedCliente");
							valVenSum = ve.getValorVenta() + valVenRep;
							valIvaSum = ve.getIvaVenta() + valIvaRep;
							valTotSum = ve.getTotalVenta() + valTotRep;
							hs.setAttribute("infoVenta", new VentaDTO(codVen, cedCli, cedUsu, valVenSum, valIvaSum, valTotSum));
							hs.setAttribute("isEmpty", false);
							response.sendRedirect("ventas.jsp?cedCli=" + (int)hs.getAttribute("cedCliente"));
						
						}
						
					}
					
				}
				
			}
			
		}
		
		if (request.getParameter("btnSubirVenta") != null) {
			
			if(hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
			
				VentaDTO ve = (VentaDTO)hs.getAttribute("infoVenta");
				VentaDAO vec = new VentaDAO();
				boolean y = vec.insertarVenta(ve);
				if(y) {
					// bien
				} else {
					// mal
				}
				ReporteDAO rec = new ReporteDAO();
				ArrayList<?> canastaTemporal = (ArrayList<?>)hs.getAttribute("datosVenta");
				for (int i = 0; i < canastaTemporal.size(); i++) {
					
					ReporteDTO re = (ReporteDTO)canastaTemporal.get(i);
					rec.insertarReporte(re);
					
				}
				//JOptionPane.showMessageDialog(null, "Venta registrada correctamente en la base de datos");
				response.sendRedirect("ventas.jsp");
			
			}
			
		}
		
	}

}