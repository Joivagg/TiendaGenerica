package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuarioDTO;
import modelo.UsuarioDAO;

/**
 * Servlet implementation class ServletGestionUsuario
 */
@WebServlet("/ServletGestionUsuario")
public class ServletGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuario() {
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
		
		String  n,e,u,p,cc;
		int c;
		boolean	y;	
		if(request.getParameter("btnCrear")!=null) {
			
			c= Integer.parseInt(request.getParameter("cedula"));
			n= request.getParameter("nombre");
			e= request.getParameter("email");
			u= request.getParameter("user");
			p= request.getParameter("pass");
			UsuarioDTO us = new UsuarioDTO(c, n, e, u, p);
			UsuarioDAO usc= new UsuarioDAO();
			y=usc.insertarusuario(us);
			if(y) {
				JOptionPane.showMessageDialog(null, "El usuario fue registrado");		
				response.sendRedirect("usuarios.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario fue no registrado");
				response.sendRedirect("usuarios.jsp");
			}
			
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			c= Integer.parseInt(request.getParameter("cedula"));
			n= request.getParameter("nombre");
			e= request.getParameter("email");
			u= request.getParameter("user");
			p= request.getParameter("pass");
			UsuarioDTO us = new UsuarioDTO(c, n, e, u, p);
			UsuarioDAO usc= new UsuarioDAO();
			y=usc.modificarusuario(us);
			if(y) {
				JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente");		
				response.sendRedirect("usuarios.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Los datos no fueron actualizados");
				response.sendRedirect("usuarios.jsp");
			}
			
		}
		
		if (request.getParameter("btnConsultar") != null) {
			
			cc = request.getParameter("cedulab");
			if (cc.isBlank()) {
				
				response.sendRedirect("usuarios.jsp");
				
			} else {
				
				UsuarioDAO usc = new UsuarioDAO();
				UsuarioDTO us = usc.consultarUsuario(cc);
				response.sendRedirect("usuarios.jsp?ced=" + us.getCedula_usuario()
								 + "&&nom=" + us.getNombre_usuario() 
								 + "&&ema=" + us.getEmail_usuario() 
								 + "&&use=" + us.getUsuario() 
								 + "&&pas=" + us.getPassword());
				
			}
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			c= Integer.parseInt(request.getParameter("cedulab"));
			UsuarioDTO us = new UsuarioDTO(c);
			UsuarioDAO usc= new UsuarioDAO();
			y=usc.eliminarUsuario(us);
			if (y) {
				JOptionPane.showMessageDialog(null, "El usuario fue eliminado");		
				response.sendRedirect("usuarios.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El usuario no fue eliminado ");
				response.sendRedirect("usuarios.jsp");
			}
			
		}
		
	}

}