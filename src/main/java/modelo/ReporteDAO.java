package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ReporteDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	ArrayList<ReporteDTO> registro = new ArrayList<>();
	
	public ArrayList<ReporteDTO> listadoReporte() {
		
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM detalle_ventas");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ReporteDTO data = new ReporteDTO(rs.getString(1),
                						   rs.getInt(2),
                						   rs.getInt(3),
                						   rs.getInt(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6),
                						   rs.getDouble(7));
                registro.add(data);
                
            }
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro;
		
	}
	
	public boolean insertarReporte(ReporteDTO re) {
		
		int x;
		boolean dato = false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO detalle_ventas values(?,?,?,?,?,?,?)");
			ps.setString(1, re.getCodigoDetalleVenta());
			ps.setInt(2, re.getCantidadProducto());
			ps.setInt(3, re.getCodigoProducto());
			ps.setInt(4, re.getCodigoVenta());
			ps.setDouble(5, re.getValorVenta());
			ps.setDouble(6, re.getValorIva());
			ps.setDouble(7, re.getValorTotal());
			x=ps.executeUpdate();
			if (x>0) {
				dato=true;
			}
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, e);
			
		}
		return dato;
		
	}
	
	public boolean modificarReporte(ReporteDTO re) {
		
		int x;
		boolean dato = false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE detalle_ventas SET cantidad_producto='" + re.getCantidadProducto()
                + "', valor_venta='" + re.getValorVenta()
                + "', valoriva='" + re.getValorIva()
                + "', valor_total='" + re.getValorTotal()
                + "' WHERE codigo_detalle_venta='" + re.getCodigoDetalleVenta() + "'");
            x = ps.executeUpdate();
            if (x>0) {
				dato=true;
			}

        } catch (SQLException e) {

            e.printStackTrace();

        }
		return dato;
		
	}
	
	public boolean verificarReporte(String codigo) {
		
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM detalle_ventas WHERE codigo_detalle_venta = ?");
			ps.setString(1, codigo);
			rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
			
		}
		
	}
	
	public ReporteDTO consultarReporte() {
		
		registro.clear();
		
		try {
        	
            ReporteDTO data = new ReporteDTO(rs.getString(1),
                						   rs.getInt(2),
                						   rs.getInt(3),
                						   rs.getInt(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6),
                						   rs.getDouble(7));
                
            registro.add(data);
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
		
		return registro.get(0);
		
	}
	
	public boolean eliminarReporte(ReporteDTO re) {
		
		int x;
		boolean dato = false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM detalle_ventas WHERE codigo_venta=?");
			ps.setString(1, re.getCodigoDetalleVenta());
			x=ps.executeUpdate();
			if(x>0)	{
				dato = true;
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		return dato;
		
	}

}