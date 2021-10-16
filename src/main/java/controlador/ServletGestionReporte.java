package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletGestionReporte
 */
@WebServlet("/ServletGestionReporte")
public class ServletGestionReporte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionReporte() {
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
		HttpSession hs = request.getSession();
		if(request.getParameter("mostrarUsuarios") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=usuarios");
				
			}
			
		}
		
		if(request.getParameter("mostrarClientes") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=clientes");
			
			}
			
		}
		
		if(request.getParameter("mostrarProveedores") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=proveedores");
				
			}
			
		}
		
		if(request.getParameter("mostrarProductos") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=productos");
				
			}
			
		}
		
		if(request.getParameter("mostrarVentas") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=ventas");
				
			}
			
		}
		
		if(request.getParameter("mostrarDetalles") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				hs.setAttribute("venta", request.getParameter("mostrarDetalles"));
				response.sendRedirect("reportes.jsp?tabla=reportes");
				
			}
			
		}
		
		if(request.getParameter("regresar") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp");
				
			}
			
		}
		
		if(request.getParameter("regresarVenta") != null) {
			
			if((String)hs.getAttribute("username") == null) {
				
				response.sendRedirect("index.jsp");
				
			} else {
				
				response.sendRedirect("reportes.jsp?tabla=ventas");
				
			}
			
		}
		
	}

}