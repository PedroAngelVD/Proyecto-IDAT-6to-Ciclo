package com.demo.model;

public class PagoReinscripcion {

	private int id_pago_reinscripcion;
	private String cod_reinscripcion;
	private String descripcion;
	private double monto;
	private String vencimiento;
	private String fecha;
	private String usuario;
	private String estado;
	
	public PagoReinscripcion() {
		super();
	}
	
	public PagoReinscripcion(int id_pago_reinscripcion, String cod_reinscripcion, String descripcion, double monto,
			String vencimiento, String fecha, String usuario, String estado) {
		super();
		this.id_pago_reinscripcion = id_pago_reinscripcion;
		this.cod_reinscripcion = cod_reinscripcion;
		this.descripcion = descripcion;
		this.monto = monto;
		this.vencimiento = vencimiento;
		this.fecha = fecha;
		this.usuario = usuario;
		this.estado = estado;
	}
	
	public int getId_pago_reinscripcion() {
		return id_pago_reinscripcion;
	}
	public void setId_pago_reinscripcion(int id_pago_reinscripcion) {
		this.id_pago_reinscripcion = id_pago_reinscripcion;
	}
	public String getCod_reinscripcion() {
		return cod_reinscripcion;
	}
	public void setCod_reinscripcion(String cod_reinscripcion) {
		this.cod_reinscripcion = cod_reinscripcion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
