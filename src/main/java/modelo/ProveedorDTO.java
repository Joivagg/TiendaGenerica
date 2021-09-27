package modelo;

public class ProveedorDTO {
	
	private int nitProveedor;
	private String nombreProveedor;
	private String direccionProveedor;
	private String telefonoProveedor;
	private String ciudadProveedor;
	
	public ProveedorDTO(int nitProveedor, String nombreProveedor, String direccionProveedor, String telefonoProveedor,
			String ciudadProveedor) {
		super();
		this.nitProveedor = nitProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
		this.ciudadProveedor = ciudadProveedor;
	}

	public ProveedorDTO(int nitProveedor) {
		super();
		this.nitProveedor = nitProveedor;
	}

	public int getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(int nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

}