package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductoDAO {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	ArrayList<ProductoDTO> registro = new ArrayList<>();
	
	public ArrayList<ProductoDTO> listadoProducto() {
		
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
        
        try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ProductoDTO data = new ProductoDTO(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getInt(3),
                						   rs.getDouble(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6));
                registro.add(data);
                
            }
            
			rs.close();
            ps.close();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro;
		
	}
	
	public boolean insertarProducto(ProductoDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato = false;
		try {
			
			ps= cnn.prepareStatement("INSERT INTO productos values(?,?,?,?,?,?)");
			ps.setInt(1, pr.getCodigoProducto());
			ps.setString(2, pr.getNombreProducto());
			ps.setInt(3, pr.getNitProveedor());
			ps.setDouble(4, pr.getPrecioCompra());
			ps.setDouble(5, pr.getIvaCompra());
			ps.setDouble(6, pr.getPrecioVenta());
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
	
    public boolean cargarproductos(String URL) {
	    
    	PreparedStatement ps;
    	boolean y = false;
	    try {
	    	
	    	ps=cnn.prepareStatement("LOAD DATA INFILE '" + URL 
	    			+ "' INTO TABLE productos FIELDS TERMINATED BY ';' LINES TERMINATED BY '\r\n';");
		    y=ps.executeUpdate()>0;
		    System.out.println(y);
		    ps.close();
		    
	    } catch(SQLException e) {
	    	
		    System.out.println("Error al registrar producto: " + e);
		    
	    }
	    return y;
    }
    
	public boolean modificarProducto(ProductoDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato = false;
		try {

            ps = cnn.prepareStatement(
                "UPDATE productos SET nombre_producto='" + pr.getNombreProducto() 
                + "', precio_compra='" + pr.getPrecioCompra()
                + "', ivacompra='" + pr.getIvaCompra()
                + "', precio_venta='" + pr.getPrecioVenta()
                + "' WHERE codigo_producto='" + pr.getCodigoProducto() + "'");
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
	
	public boolean verificarProducto(String codigo) {
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			
			ps = cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto = ?");
			ps.setInt(1, Integer.parseInt(codigo));
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
	
	public ProductoDTO consultarProducto(int codigoProducto) {
        
		PreparedStatement ps;
		ResultSet rs;
		registro.clear();
		
		try {
        	
        	ps = cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
        	ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            while (rs.next()) {
                
                ProductoDTO data = new ProductoDTO(rs.getInt(1),
                						   rs.getString(2),
                						   rs.getInt(3),
                						   rs.getDouble(4),
                						   rs.getDouble(5),
                						   rs.getDouble(6));
                registro.add(data);
                
            }
            
			rs.close();
            ps.close();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
        return registro.get(0);
		
	}
	
	public boolean eliminarProducto(ProductoDTO pr) {
		
		PreparedStatement ps;
		int x;
		boolean dato=false;
		try {
			
			ps= cnn.prepareStatement("DELETE FROM productos WHERE codigo_producto=?");
			ps.setInt(1, pr.getCodigoProducto() );
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