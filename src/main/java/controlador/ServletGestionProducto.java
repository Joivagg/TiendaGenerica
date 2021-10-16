package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;
import modelo.ProductoDTO;

/**
 * Servlet implementation class ServletGestionProductos
 */
@WebServlet("/ServletGestionProducto")
public class ServletGestionProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProducto() {
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
		String nom, codb;
		int cod, nit;
		double prec, iva, prev;
		boolean y;
		if(request.getParameter("btnCrear")!=null) {
			
			cod= Integer.parseInt(request.getParameter("codigo"));
			nom= request.getParameter("nombre");
			nit= Integer.parseInt(request.getParameter("nit"));
			prec= Double.parseDouble(request.getParameter("preciob"));
			iva= Double.parseDouble(request.getParameter("iva"));
			prev= Double.parseDouble(request.getParameter("precion"));
			ProductoDTO pr = new ProductoDTO(cod, nom, nit, prec, iva, prev);
			ProductoDAO prc= new ProductoDAO();
			y=prc.insertarProducto(pr);
			if(y) {
				JOptionPane.showMessageDialog(null, "El producto fue registrado");		
				response.sendRedirect("productos.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El producto no fue registrado");
				response.sendRedirect("productos.jsp");
			}
			
		}
		
		if(request.getParameter("btnCargar")!=null) {
			
			response.sendRedirect("subirproductos.jsp");
			
		}
		
		if(request.getParameter("btnModificar")!=null) {
			
			cod= Integer.parseInt(request.getParameter("codigo"));
			nom= request.getParameter("nombre");
			nit= Integer.parseInt(request.getParameter("nit"));
			prec= Double.parseDouble(request.getParameter("preciob"));
			iva= Double.parseDouble(request.getParameter("iva"));
			prev = Double.parseDouble(request.getParameter("precion"));
			ProductoDTO pr = new ProductoDTO(cod, nom, nit, prec, iva, prev);
			ProductoDAO prc= new ProductoDAO();
			y=prc.modificarProducto(pr);
			if(y) {
				JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente");		
				response.sendRedirect("productos.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Los datos no fueron actualizados");
				response.sendRedirect("productos.jsp");
			}
			
		}
		
		if (request.getParameter("btnConsultar") != null) {
			
			codb = request.getParameter("codigob");
			ProductoDAO prc = new ProductoDAO();
			if (codb.isBlank()) {
				
				response.sendRedirect("productos.jsp");					
								
			} else {
				
				if (!prc.verificarProducto(codb)) {
					
					JOptionPane.showMessageDialog(null, "El producto no está registrado");
					response.sendRedirect("productos.jsp");
					
				} else {
				
					ProductoDTO pr = prc.consultarProducto(Integer.parseInt(codb));
					HttpSession hs = request.getSession();
					hs.setAttribute("producto", pr);
					response.sendRedirect("productos.jsp?cod=" + pr.getCodigoProducto());
				
				}
				
			}
			
		}
		
		if (request.getParameter("btnEliminar") != null) {
			cod= Integer.parseInt(request.getParameter("codigo"));
			ProductoDTO pr = new ProductoDTO(cod);
			ProductoDAO prc= new ProductoDAO();
			y=prc.eliminarProducto(pr);
			if (y) {
				JOptionPane.showMessageDialog(null, "El producto fue eliminado");		
				response.sendRedirect("productos.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "El producto no fue eliminado");
				response.sendRedirect("productos.jsp");
			}
			
		}
	}

}
