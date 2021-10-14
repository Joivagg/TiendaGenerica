package modelo;

public class VentaDTO {
	
	private int codigoVenta;
	private int cedulaCliente;
	private int cedulaUsuario;
	private double valorVenta;
	private double ivaVenta;
	private double totalVenta;
	
	public VentaDTO(int codigoVenta, int cedulaCliente, int cedulaUsuario, double valorVenta, double ivaVenta,
			double totalVenta) {
		super();
		this.codigoVenta = codigoVenta;
		this.cedulaCliente = cedulaCliente;
		this.cedulaUsuario = cedulaUsuario;
		this.valorVenta = valorVenta;
		this.ivaVenta = ivaVenta;
		this.totalVenta = totalVenta;
	}

	public VentaDTO(int codigoVenta) {
		super();
		this.codigoVenta = codigoVenta;
	}

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public int getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(int cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public int getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}

	public double getIvaVenta() {
		return ivaVenta;
	}

	public void setIvaVenta(double ivaVenta) {
		this.ivaVenta = ivaVenta;
	}

	public double getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}

}