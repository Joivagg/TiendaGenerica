package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductoDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
    public boolean cargarproductos(String URL) {
	    JOptionPane.showMessageDialog(null, "en dao" + URL);
	    boolean y = false;
	    try {
	    	ps=cnn.prepareStatement("LOAD DATA INFILE '" + URL 
	    			+ "' INTO TABLE productos FIELDS TERMINATED BY ';' LINES TERMINATED BY '\r\n';");
		    JOptionPane.showMessageDialog(null, "en ps");
		    y=ps.executeUpdate()>0;
		    JOptionPane.showMessageDialog(null, y);
		    
	    } catch(SQLException e) {
	    	
		    JOptionPane.showMessageDialog(null, "Error al registrar producto: " + e);
		    
	    }
	    return y;
    }
    
}