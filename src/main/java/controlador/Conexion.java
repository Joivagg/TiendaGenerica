package controlador;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection cnn;
	
	public Connection conexiondb() {
		
		/*try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			try	{
				cnn= DriverManager.getConnection("jdbc:mysql://localhost/tiendagen","root", "");
				JOptionPane.showMessageDialog(null, "conexion ok");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Falló conexión");
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "Fallo driver");
			e.printStackTrace();
			
		}
		
		return cnn;*/
		
		try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch(ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Error de driver: " + ex);
            
        }
        
        try{
            
            cnn = DriverManager.getConnection("jdbc:mysql://localhost/tiendagen", "root", "");
            
        } catch(SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error en la ruta de conexión: " + ex);
            
        }
        
        return cnn;
		
	}

}