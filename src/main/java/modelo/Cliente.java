package modelo;

public class Cliente {
	
	private int cedulaCliente;
	private String nombreCliente;
	private String direccionCliente;
	private String telefonoCliente;
	private String emailCliente;
	
	public Cliente(int cedulaCliente, String nombreCliente, String direccionCliente, String telefonoCliente,
			String emailCliente) {
		super();
		this.cedulaCliente = cedulaCliente;
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		this.telefonoCliente = telefonoCliente;
		this.emailCliente = emailCliente;
	}
	
	public Cliente(int cedulaCliente) {
		super();
		this.cedulaCliente = cedulaCliente;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}
	
	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getDireccionCliente() {
		return direccionCliente;
	}
	
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	public String getTelefonoCliente() {
		return telefonoCliente;
	}
	
	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	public String getEmailCliente() {
		return emailCliente;
	}
	
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

}