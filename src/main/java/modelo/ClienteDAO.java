package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class ClienteDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	ArrayList<ClienteDTO> registro = new ArrayList<>();
	
	public ArrayList<ClienteDTO> listadoCliente() {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        		
        	ps = cnn.prepareStatement("SELECT * FROM clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ClienteDTO data = new ClienteDTO(rs.getInt(1),
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
	
	public boolean insertarCliente(ClienteDTO cl) {
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO clientes values(?,?,?,?,?)");
			ps.setInt(1, cl.getCedulaCliente());
			ps.setString(2, cl.getNombreCliente());
			ps.setString(3, cl.getDireccionCliente());
			ps.setString(4, cl.getTelefonoCliente());
			ps.setString(5, cl.getEmailCliente());
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
	
	public boolean modificarCliente(ClienteDTO cl) {
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE clientes SET nombre_cliente='" + cl.getNombreCliente() 
                + "', direccion_cliente='" + cl.getDireccionCliente()
                + "', telefono_cliente='" + cl.getTelefonoCliente()
                + "', email_cliente='" + cl.getEmailCliente()
                + "' WHERE cedula_cliente='" + cl.getCedulaCliente() + "'");
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
	
	public boolean verificarCliente(String cedula) {
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente = ?");
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
	
	public ClienteDTO consultarCliente(int cedula) {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        		
        	ps = cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
        	ps.setInt(1, cedula);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ClienteDTO data = new ClienteDTO(rs.getInt(1),
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
	
	public boolean elminarCliente(ClienteDTO cl) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cl.getCedulaCliente() );
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