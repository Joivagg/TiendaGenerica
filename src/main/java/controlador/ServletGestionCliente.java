package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.swing.JOptionPane;

import modelo.ClienteDTO;
import modelo.ClienteDAO;

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
		
		String  n,d,t,e,cc;
		int c;
		boolean	y;
		HttpSession hs = request.getSession();
		if(request.getParameter("btnCrear")!=null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				c= Integer.parseInt(request.getParameter("cedula"));
				n= request.getParameter("nombre");
				d= request.getParameter("direccion");
				t= request.getParameter("telefono");
				e= request.getParameter("email");
				ClienteDTO cl = new ClienteDTO(c, n, d, t, e);
				ClienteDAO clc= new ClienteDAO();
				y=clc.insertarCliente(cl);
				if(y) {
					//JOptionPane.showMessageDialog(null, "El cliente fue registrado");		
					response.sendRedirect("clientes.jsp");
				} else {
					//JOptionPane.showMessageDialog(null, "El cliente no fue registrado");
					response.sendRedirect("clientes.jsp");
				}
				
			}
			
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				c= Integer.parseInt(request.getParameter("cedula"));
				n= request.getParameter("nombre");
				d= request.getParameter("direccion");
				t= request.getParameter("telefono");
				e= request.getParameter("email");
				ClienteDTO cl = new ClienteDTO(c, n, d, t, e);
				ClienteDAO clc= new ClienteDAO();
				y=clc.modificarCliente(cl);
				if(y) {
					//JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente");		
					response.sendRedirect("clientes.jsp");
				} else {
					//JOptionPane.showMessageDialog(null, "Los datos no fueron actualizados");
					response.sendRedirect("clientes.jsp");
				}
				
			}
			
		}
		
		if (request.getParameter("btnConsultar") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				cc = request.getParameter("cedulab");
				ClienteDAO clc = new ClienteDAO();
				if (cc.isBlank()) {
					
					response.sendRedirect("clientes.jsp");					
									
				} else {
					
					if (!clc.verificarCliente(cc)) {
						
						//JOptionPane.showMessageDialog(null, "El cliente no está registrado");
						response.sendRedirect("clientes.jsp");
						
					} else {
					
						ClienteDTO cl = clc.consultarCliente(Integer.parseInt(cc));
						hs.setAttribute("cliente", cl);
						response.sendRedirect("clientes.jsp?ced=" + cl.getCedulaCliente());
					
					}
					
				}
				
			}
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				c= Integer.parseInt(request.getParameter("cedula"));
				ClienteDTO cl = new ClienteDTO(c);
				ClienteDAO clc= new ClienteDAO();
				y=clc.elminarCliente(cl);
				if (y) {
					//JOptionPane.showMessageDialog(null, "El cliente fue eliminado");		
					response.sendRedirect("clientes.jsp");
				} else {
					//JOptionPane.showMessageDialog(null, "El cliente no fue eliminado");
					response.sendRedirect("clientes.jsp");
				}
				
			}
			
		}
		
	}

}