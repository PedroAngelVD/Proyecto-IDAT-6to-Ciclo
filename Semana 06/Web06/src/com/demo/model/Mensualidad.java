package com.demo.model;

public class Mensualidad {

	private int id_hab_mensualidad;
	private String cod_mensualidad;
	private String descripcion;
	private double monto;
	private String vencimiento;
	private String codigo_reinscripcion;
	
	public Mensualidad() {
		
	}

	public Mensualidad(int id_hab_mensualidad, String cod_mensualidad, String descripcion, double monto,
			String vencimiento, String codigo_reinscripcion) {
		
		this.id_hab_mensualidad = id_hab_mensualidad;
		this.cod_mensualidad = cod_mensualidad;
		this.descripcion = descripcion;
		this.monto = monto;
		this.vencimiento = vencimiento;
		this.codigo_reinscripcion = codigo_reinscripcion;
	}
	
	public int getId_hab_mensualidad() {
		return id_hab_mensualidad;
	}
	public void setId_hab_mensualidad(int id_hab_mensualidad) {
		this.id_hab_mensualidad = id_hab_mensualidad;
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
	public String getCodigo_reinscripcion() {
		return codigo_reinscripcion;
	}
	public void setCodigo_reinscripcion(String codigo_reinscripcion) {
		this.codigo_reinscripcion = codigo_reinscripcion;
	}
	
}
