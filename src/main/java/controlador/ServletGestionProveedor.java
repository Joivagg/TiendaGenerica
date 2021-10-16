package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ProveedorDTO;
import modelo.ProveedorDAO;

/**
 * Servlet implementation class ServletGestionProveedor
 */
@WebServlet("/ServletGestionProveedor")
public class ServletGestionProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProveedor() {
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
		// doGet(request, response);
		
		String  n,d,t,c,nt;
		int nit;
		boolean	y;
		HttpSession hs = request.getSession();
		if(request.getParameter("btnCrear")!=null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				nit= Integer.parseInt(request.getParameter("nit"));
				n= request.getParameter("nombre");
				d= request.getParameter("direccion");
				t= request.getParameter("telefono");
				c= request.getParameter("ciudad");
				ProveedorDTO pr = new ProveedorDTO(nit, n, d, t, c);
				ProveedorDAO prc= new ProveedorDAO();
				y=prc.insertarProveedor(pr);
				if(y) {
					JOptionPane.showMessageDialog(null, "El proveedor fue registrado");		
					response.sendRedirect("proveedores.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "El proveedor no fue registrado");
					response.sendRedirect("proveedores.jsp");
				}
				
			}
			
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				nit= Integer.parseInt(request.getParameter("nit"));
				n= request.getParameter("nombre");
				d= request.getParameter("direccion");
				t= request.getParameter("telefono");
				c= request.getParameter("ciudad");
				ProveedorDTO pr = new ProveedorDTO(nit, n, d, t, c);
				ProveedorDAO prc= new ProveedorDAO();
				y=prc.modificarProveedor(pr);
				if(y) {
					JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente");		
					response.sendRedirect("proveedores.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "Los datos no fueron actualizados");
					response.sendRedirect("proveedores.jsp");
				}
				
			}
			
		}
		
		if (request.getParameter("btnConsultar") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				nt = request.getParameter("nitb");
				ProveedorDAO prc = new ProveedorDAO();
				if (nt.isBlank()) {
					
					response.sendRedirect("proveedores.jsp");					
									
				} else {
					
					if (!prc.verificarProveedor(nt)) {
						
						JOptionPane.showMessageDialog(null, "El proveedor no está registrado");
						response.sendRedirect("proveedores.jsp");
						
					} else {
					
						ProveedorDTO pr = prc.consultarProveedor(Integer.parseInt(nt));
						hs.setAttribute("proveedor", pr);
						response.sendRedirect("proveedores.jsp?nit=" + pr.getNitProveedor());
					
					}
					
				}
				
			}
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				nit= Integer.parseInt(request.getParameter("nit"));
				ProveedorDTO pr = new ProveedorDTO(nit);
				ProveedorDAO prc= new ProveedorDAO();
				y=prc.elminarProveedor(pr);
				if (y) {
					JOptionPane.showMessageDialog(null, "El proveedor fue eliminado");		
					response.sendRedirect("proveedores.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "El proveedor no fue eliminado");
					response.sendRedirect("proveedores.jsp");
				}
				
			}
			
		}
		
	}

}