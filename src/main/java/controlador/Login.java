package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		if (request.getParameter("btnAceptar")!=null) {
			String u,c;
			u= request.getParameter("user");
			c= request.getParameter("pass");
			UsuarioDAO usc = new UsuarioDAO();
			if (usc.verificarLogin(u, c)) {
				HttpSession ms = request.getSession(true);
				ms.setAttribute("username", u);
				if (!usc.consultarCedulaUsuario(u)) {
					
					JOptionPane.showMessageDialog(null, "El usuario no está registrado");
					
				} else {
				
					UsuarioDTO us = usc.consultarUsuario(u);
					ms.setAttribute("cedUsuario", us.getCedula_usuario());
				
				}
				response.sendRedirect("usuarios.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				response.sendRedirect("index.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
