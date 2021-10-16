package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class UsuarioDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	ArrayList<UsuarioDTO> registro = new ArrayList<>();
	
	public ArrayList<UsuarioDTO> listadoUsuario() {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM usuarios");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                UsuarioDTO data = new UsuarioDTO(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getString(3),
                						   rs.getString(4),
                						   rs.getString(5));
                registro.add(data);
                
            }
            
            rs.close();
            ps.close();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro;
		
	}
	
	public boolean insertarUsuario(UsuarioDTO us) {
		
		PreparedStatement ps;
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
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return dato;
	}
	
	public boolean modificarUsuario(UsuarioDTO us) {
		
		PreparedStatement ps;
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
            ps.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
		return dato;
	}
	
	public boolean verificarUsuario(String cedula) {
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario = ?");
			ps.setInt(1, Integer.parseInt(cedula));
			rs = ps.executeQuery();
			boolean resObt = rs.next();
			rs.close();
            ps.close();
			return resObt;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public boolean consultarCedulaUsuario(String user) {
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
			ps.setString(1, user);
			rs = ps.executeQuery();
			boolean resObt = rs.next();
			rs.close();
            ps.close();
			return resObt;
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			return false;
			
		}
		
	}
	
	public boolean verificarLogin(String user, String password) {
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND password = ?");
			ps.setString(1, user);
			ps.setString(2, password);
			rs = ps.executeQuery();
			boolean resObt = rs.next();
			rs.close();
            ps.close();
			return resObt;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public UsuarioDTO consultarUsuario(int cedula) {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
        	ps.setInt(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                UsuarioDTO data = new UsuarioDTO(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getString(3),
                						   rs.getString(4),
                						   rs.getString(5));
                registro.add(data);
                
            }
            
			rs.close();
            ps.close();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro.get(0);
		
	}
	
	public UsuarioDTO consultarUsuario(String user) {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
        	ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                UsuarioDTO data = new UsuarioDTO(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getString(3),
                						   rs.getString(4),
                						   rs.getString(5));
                registro.add(data);
                
            }
            
			rs.close();
            ps.close();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro.get(0);
		
	}
	
	public boolean eliminarUsuario(UsuarioDTO us) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, us.getCedula_usuario() );
			x=ps.executeUpdate();
			if(x>0)	{
				dato=true;
			}
			
			ps.close();
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dato;
	}

}