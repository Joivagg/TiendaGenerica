package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class ProveedorDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	ArrayList<ProveedorDTO> registro = new ArrayList<>();
	
	public ArrayList<ProveedorDTO> listadoProveedor() {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
		try {
    		
        	ps = cnn.prepareStatement("SELECT * FROM proveedores");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ProveedorDTO data = new ProveedorDTO(rs.getInt(1),
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
	
	public boolean insertarProveedor(ProveedorDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO proveedores values(?,?,?,?,?)");
			ps.setInt(1, pr.getNitProveedor());
			ps.setString(2, pr.getNombreProveedor());
			ps.setString(3, pr.getDireccionProveedor());
			ps.setString(4, pr.getTelefonoProveedor());
			ps.setString(5, pr.getCiudadProveedor());
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
	
	public boolean modificarProveedor(ProveedorDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE proveedores SET nombre_proveedor='" + pr.getNombreProveedor() 
                + "', direccion_proveedor='" + pr.getDireccionProveedor()
                + "', telefono_proveedor='" + pr.getTelefonoProveedor()
                + "', ciudad_proveedor='" + pr.getCiudadProveedor()
                + "' WHERE nitproveedor='" + pr.getNitProveedor() + "'");
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
	
	public boolean verificarProveedor(String nit) {
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor = ?");
			ps.setInt(1, Integer.parseInt(nit));
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
	
	public ProveedorDTO consultarProveedor(int nit) {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
		try {
    		
        	ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
        	ps.setInt(1, nit);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ProveedorDTO data = new ProveedorDTO(rs.getInt(1),
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
	
	public boolean elminarProveedor(ProveedorDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, pr.getNitProveedor() );
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