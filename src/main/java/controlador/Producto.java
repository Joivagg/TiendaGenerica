package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;
import modelo.ProductoDAO;

/**
 * Servlet implementation class Productos
 */
@WebServlet("/Producto")
@MultipartConfig
public class Producto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producto() {
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
		//doGet(request, response);
		Part archivo = request.getPart("archivo");
		String home = System.getProperty("user.home");
		String Url = home.replace("\\", "\\\\") + "\\\\git\\\\repository\\\\tg\\\\TiendaGenerica\\\\src\\\\main\\\\webapp\\\\docs\\\\";
		if (request.getParameter("cargar") != null) {
			try {
				InputStream file = archivo.getInputStream();
				JOptionPane.showMessageDialog(null, Url);
				File copia = new File(Url + "listaproductos.csv");
				FileOutputStream escribir = new FileOutputStream(copia);
				int num = file.read();
				while(num != -1) {
					escribir.write(num);
					num = file.read();
				}
				file.close();
				escribir.close();
				boolean x;
				JOptionPane.showMessageDialog(null, "se cargo el archivo con exito);");
				ProductoDAO prodao = new ProductoDAO();
				x = prodao.cargarproductos(Url+"listaproductos.csv");
				if (x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en la bd");
					response.sendRedirect("productos.jsp");
				} else {
					JOptionPane.showMessageDialog(null, "No se cargaron los productos en la bd");
					response.sendRedirect("productos.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
				JOptionPane.showMessageDialog(null, e);
				response.sendRedirect("productos.jsp");
			}
		}
	}
}
