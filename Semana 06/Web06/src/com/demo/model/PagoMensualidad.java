package com.demo.model;

public class PagoMensualidad {
	
	private int id_pago_mensualidad;
	private String cod_mensualidad;
	private String descripcion;
	private double monto;
	private String vencimiento;
	private String fecha;
	private String cod_reinscripcion;
	private String estado;
	private String usuario;
	
	public PagoMensualidad() {
		super();
	}
	
	public PagoMensualidad(int id_pago_mensualidad, String cod_mensualidad, String descripcion, double monto,
			String vencimiento, String fecha, String cod_reinscripcion, String estado, String usuario) {
		super();
		this.id_pago_mensualidad = id_pago_mensualidad;
		this.cod_mensualidad = cod_mensualidad;
		this.descripcion = descripcion;
		this.monto = monto;
		this.vencimiento = vencimiento;
		this.fecha = fecha;
		this.cod_reinscripcion = cod_reinscripcion;
		this.estado = estado;
		this.usuario = usuario;
	}
	
	public int getId_pago_mensualidad() {
		return id_pago_mensualidad;
	}
	public void setId_pago_mensualidad(int id_pago_mensualidad) {
		this.id_pago_mensualidad = id_pago_mensualidad;
	}
	public String getCod_mensualidad() {
		return cod_mensualidad;
	}
	public void setCod_mensualidad(String cod_mensualidad) {
		this.cod_mensualidad = cod_mensualidad;
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
	public String getCod_reinscripcion() {
		return cod_reinscripcion;
	}
	public void setCod_reinscripcion(String cod_reinscripcion) {
		this.cod_reinscripcion = cod_reinscripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
