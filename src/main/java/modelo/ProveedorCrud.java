package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class ProveedorCrud {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<Proveedor> registro = new ArrayList<>();
	
	public ArrayList<Proveedor> listadoProveedor (String nit) {
		
		registro.clear();
        
        try {
        	
        	if (nit == null) {
        		
        		ps = cnn.prepareStatement("SELECT * FROM proveedores");
        		
        	} else {
        		
        		ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor = '"
        								  + nit + "'");
        		
        	}
            
            rs = ps.executeQuery();
            while (rs.next()) {
                
                Proveedor data = new Proveedor(rs.getInt(1),
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
	
	public boolean insertarProveedor (Proveedor pr) {
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
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return dato;
	}
	
	public boolean modificarProveedor (Proveedor pr) {
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

        } catch (SQLException e) {

            e.printStackTrace();

        }
		return dato;
	}
	
	public boolean elminarProveedor (Proveedor pr) {
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, pr.getNitProveedor() );
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