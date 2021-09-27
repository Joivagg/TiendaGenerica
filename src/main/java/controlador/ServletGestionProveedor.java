package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		String  n,d,t,c;
		int nit;
		boolean	y;	
		if(request.getParameter("btnCrear")!=null) {
			
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
		
		if(request.getParameter("btnModificar")!=null) {
			
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
		
		if (request.getParameter("btnConsultar") != null) {
			
			nit = Integer.parseInt(request.getParameter("nitb"));
			response.sendRedirect("proveedores.jsp");
			request.setAttribute("nitb", nit);
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			nit= Integer.parseInt(request.getParameter("nitb"));
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