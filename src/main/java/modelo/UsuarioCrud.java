package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class UsuarioCrud {
	
	Conexion con= new Conexion();
	Connection cnn= con.conexiondb();
	PreparedStatement ps;
	ResultSet rs;
	
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
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}
		return dato;
	}
	public boolean elminarusuario(Usuario us)
	{
		int x;
		boolean dato=false;
		try {
			ps= cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, us.getCedula_usuario() );
			x=ps.executeUpdate();
			if(x>0)
			{
				dato=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}

}
