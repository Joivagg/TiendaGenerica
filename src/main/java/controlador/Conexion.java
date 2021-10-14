package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection cnn;
	
	public Connection conexiondb() {

		try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            try {
                
                cnn = DriverManager.getConnection("jdbc:mysql://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/tiendagenericagrupo32equipo3", "admin", "123456789");
                
            } catch(SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error en la ruta de conexión: " + ex);
                
            }
            
        } catch(ClassNotFoundException ex) {
            
            JOptionPane.showMessageDialog(null, "Error de driver: " + ex);
            
        }
        
        return cnn;
		
	}

}