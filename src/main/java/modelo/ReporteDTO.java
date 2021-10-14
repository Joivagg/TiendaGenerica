package modelo;

public class ReporteDTO {
	
	private String codigoDetalleVenta;
	private int cantidadProducto;
	private int codigoProducto;
	private int codigoVenta;
	private double valorVenta;
	private double valorIva;
	private double valorTotal;
	
	public ReporteDTO(String codigoDetalleVenta, int cantidadProducto, int codigoProducto, int codigoVenta,
			double valorVenta, double valorIva, double valorTotal) {
		super();
		this.codigoDetalleVenta = codigoDetalleVenta;
		this.cantidadProducto = cantidadProducto;
		this.codigoProducto = codigoProducto;
		this.codigoVenta = codigoVenta;
		this.valorVenta = valorVenta;
		this.valorIva = valorIva;
		this.valorTotal = valorTotal;
	}


	public ReporteDTO(String codigoDetalleVenta) {
		super();
		this.codigoDetalleVenta = codigoDetalleVenta;
	}


	public String getCodigoDetalleVenta() {
		return codigoDetalleVenta;
	}


	public void setCodigoDetalleVenta(String codigoDetalleVenta) {
		this.codigoDetalleVenta = codigoDetalleVenta;
	}


	public int getCantidadProducto() {
		return cantidadProducto;
	}


	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}


	public int getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public int getCodigoVenta() {
		return codigoVenta;
	}


	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}


	public double getValorVenta() {
		return valorVenta;
	}


	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}


	public double getValorIva() {
		return valorIva;
	}


	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

}