package com.demo.model;

public class Reinscripcion {

	private int id_hab_reinscripcion;
	private String cod_reinscripcion;
	private String descripcion;
	private double monto;
	private String vencimiento;
	
	public Reinscripcion() {
		super();
	}

	public Reinscripcion(int id_hab_reinscripcion, String cod_reinscripcion, String descripcion, double monto,
			String vencimiento) {
		super();
		this.id_hab_reinscripcion = id_hab_reinscripcion;
		this.cod_reinscripcion = cod_reinscripcion;
		this.descripcion = descripcion;
		this.monto = monto;
		this.vencimiento = vencimiento;
	}
	
	public int getId_hab_reinscripcion() {
		return id_hab_reinscripcion;
	}
	public void setId_hab_reinscripcion(int id_hab_reinscripcion) {
		this.id_hab_reinscripcion = id_hab_reinscripcion;
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
	
}
