package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controlador.Conexion;

public class VentaDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<VentaDTO> registro = new ArrayList<>();
	
	public ArrayList<VentaDTO> listadoVenta() {
		
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM ventas");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                VentaDTO data = new VentaDTO(rs.getInt(1),
                						   rs.getInt(2),
                						   rs.getInt(3),
                						   rs.getDouble(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6));
                registro.add(data);
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro;
		
	}
	
	public boolean insertarVenta(VentaDTO ve) {
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO ventas values(?,?,?,?,?,?)");
			ps.setInt(1, ve.getCodigoVenta());
			ps.setInt(2, ve.getCedulaCliente());
			ps.setInt(3, ve.getCedulaUsuario());
			ps.setDouble(4, ve.getValorVenta());
			ps.setDouble(5, ve.getIvaVenta());
			ps.setDouble(6, ve.getTotalVenta());
			x=ps.executeUpdate();
			if (x>0) {
				dato=true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		return dato;
	}
	
	public boolean modificarVenta(VentaDTO ve) {
		int x;
		boolean dato=false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE ventas SET valor_venta='" + ve.getValorVenta() 
                + "' WHERE codigo_venta='" + ve.getCodigoVenta() + "'");
            x = ps.executeUpdate();
            if (x>0) {
				dato=true;
			}

        } catch (SQLException e) {

            e.printStackTrace();

        }
		return dato;
	}
	
	public boolean verificarVenta(String codigo) {
		
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM ventas WHERE codigo_venta = ?");
			ps.setInt(1, Integer.parseInt(codigo));
			rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public VentaDTO consultarVenta() {
		
		registro.clear();
		
		try {
        	
            VentaDTO data = new VentaDTO(rs.getInt(1),
                						   rs.getInt(2),
                						   rs.getInt(3),
                						   rs.getDouble(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6));
                
            registro.add(data);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
		
		return registro.get(0);
		
	}
	
	public boolean eliminarVenta(VentaDTO ve) {
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM ventas WHERE codigo_venta=?");
			ps.setInt(1, ve.getCodigoVenta() );
			x=ps.executeUpdate();
			if(x>0)	{
				dato=true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dato;
	}

}