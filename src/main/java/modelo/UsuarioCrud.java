package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class UsuarioCrud {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<Usuario> registro = new ArrayList<>();
	
	public ArrayList<Usuario> listadoUsuario (String cedula) {
		
		registro.clear();
        
        try {
        	
        	if (cedula == null) {
        		
        		ps = cnn.prepareStatement("SELECT * FROM usuarios");
        		
        	} else {
        		
        		ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = '"
        								  + cedula + "'");
        		
        	}
            
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Usuario data = new Usuario(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getString(3),
                						   rs.getString(4),
                						   rs.getString(5));
                registro.add(data);
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro;
		
	}
	
	public boolean insertarusuario (Usuario us) {
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO usuarios values(?,?,?,?,?)");
			ps.setInt(1, us.getCedula_usuario());
			ps.setString(2, us.getNombre_usuario());
			ps.setString(3, us.getEmail_usuario());
			ps.setString(4, us.getUsuario());
			ps.setString(5, us.getPassword());
			x=ps.executeUpdate();
			if (x>0) {
				dato=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return dato;
	}
	
	public boolean modificarusuario (Usuario us) {
		int x;
		boolean dato=false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE usuarios SET nombre_usuario='" + us.getNombre_usuario() 
                + "', email_usuario='" + us.getEmail_usuario()
                + "', usuario='" + us.getUsuario()
                + "', password='" + us.getPassword()
                + "' WHERE cedula_usuario='" + us.getCedula_usuario() + "'");
            x = ps.executeUpdate();
            if (x>0) {
				dato=true;
			}

        } catch (SQLException e) {

            e.printStackTrace();

        }
		return dato;
	}
	
	public boolean elminarusuario (Usuario us) {
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, us.getCedula_usuario() );
			x=ps.executeUpdate();
			if(x>0)	{
				dato=true;
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return dato;
	}

}