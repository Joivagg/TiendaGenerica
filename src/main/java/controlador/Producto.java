package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import modelo.ProductoDAO;
import modelo.ProductoDTO;

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
		// doGet(request, response);
		Part archivo = request.getPart("archivo");
		String data = "";
		String home = System.getProperty("user.home");
		String url = home.replace("\\", "\\\\") + "\\\\AppData\\\\Local\\\\Temp\\\\";
		//String Url = home.replace("\\", "\\\\") + "\\\\git\\\\repository\\\\tg\\\\TiendaGenerica\\\\src\\\\main\\\\webapp\\\\docs\\\\";

		if (request.getParameter("cargar") != null) {
			HttpSession hs = request.getSession();
			hs.setAttribute("mensaje", "");
			try {
				InputStream file = archivo.getInputStream();
				File copia = new File(url + "listaproductos.csv");
				FileOutputStream escribir = new FileOutputStream(copia);
				int num = file.read();
				while(num != -1) {
					
					escribir.write(num);
					num = file.read();
					
				}
				file.close();
				escribir.close();
				BufferedReader br = new BufferedReader(new FileReader(url + "listaproductos.csv"));
				data = br.readLine();
				while(data != null) {
					
					String[] info = data.split(";");
					ProductoDAO prdc = new ProductoDAO();
					prdc.insertarProducto(new ProductoDTO(Integer.parseInt(info[0]),
														  info[1],
														  Integer.parseInt(info[2]),
														  Double.parseDouble(info[3]),
														  Double.parseDouble(info[4]),
														  Double.parseDouble(info[5])));
					data = br.readLine();
					
				}
				br.close();
				response.sendRedirect("productos.jsp");
				/*boolean x;
				ProductoDAO prodao = new ProductoDAO();r
				x = prodao.cargarproductos(url+"listaproductos.csv");
				if (x) {
					hs.setAttribute("mensaje", hs.getAttribute("mensaje") + "\nDatos cargados en la bd");
					//JOptionPane.showMessageDialog(null, "Datos cargados en la bd");
					response.sendRedirect("productos.jsp");
				} else {
					hs.setAttribute("mensaje", hs.getAttribute("mensaje") + "\nNo se cargaron los productos en la bd");
					//JOptionPane.showMessageDialog(null, "No se cargaron los productos en la bd");
					response.sendRedirect("productos.jsp");
				}*/
			} catch (Exception e) {
				// TODO: handle exception
				hs.setAttribute("mensaje", hs.getAttribute("mensaje") + "\nError al cargar el archivo" + e);
				//JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
				//JOptionPane.showMessageDialog(null, e);
				response.sendRedirect("productos.jsp");
			}
		}
	}
}
