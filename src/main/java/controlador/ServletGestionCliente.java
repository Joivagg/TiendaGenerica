package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.ClienteCrud;

/**
 * Servlet implementation class ServletGestionCliente
 */
@WebServlet("/ServletGestionCliente")
public class ServletGestionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionCliente() {
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
		
		String  n,d,t,e;
		int c;
		boolean	y;	
		if(request.getParameter("btnCrear")!=null) {
			
			c= Integer.parseInt(request.getParameter("cedula"));
			n= request.getParameter("nombre");
			d= request.getParameter("direccion");
			t= request.getParameter("telefono");
			e= request.getParameter("email");
			Cliente cl = new Cliente(c, n, d, t, e);
			ClienteCrud clc= new ClienteCrud();
			y=clc.insertarCliente(cl);
			if(y) {
				 JOptionPane.showMessageDialog(null, "El cliente fue registrado");		
				 response.sendRedirect("clientes.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El cliente no fue registrado");
				response.sendRedirect("clientes.jsp");
			}
			
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			c= Integer.parseInt(request.getParameter("cedula"));
			n= request.getParameter("nombre");
			d= request.getParameter("direccion");
			t= request.getParameter("telefono");
			e= request.getParameter("email");
			Cliente cl = new Cliente(c, n, d, t, e);
			ClienteCrud clc= new ClienteCrud();
			y=clc.modificarCliente(cl);
			if(y) {
				 JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente");		
				 response.sendRedirect("clientes.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Los datos no fueron actualizados");
				response.sendRedirect("clientes.jsp");
			}
			
		}
		
		if (request.getParameter("btnConsultar") != null) {
			
			c = Integer.parseInt(request.getParameter("cedulab"));
			response.sendRedirect("clientes.jsp");
			request.setAttribute("cedulab", c);
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			c= Integer.parseInt(request.getParameter("cedulab"));
			Cliente cl = new Cliente(c);
			ClienteCrud clc= new ClienteCrud();
			y=clc.elminarCliente(cl);
			if (y) {
				JOptionPane.showMessageDialog(null, "El cliente fue eliminado");		
				response.sendRedirect("clientes.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El cliente no fue eliminado ");
				response.sendRedirect("clientes.jsp");
			}
			
		}
		
	}

}