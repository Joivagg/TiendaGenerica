package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection cnn;
	
	public Connection conexiondb() {

		try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                
                cnn = DriverManager.getConnection("jdbc:mysql://localhost/tiendagen", "root", "");
                
            } catch(SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error en la ruta de conexión: " + ex);
                
            }
            
        } catch(ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Error de driver: " + ex);
            
        }
        
        return cnn;
		
	}

}