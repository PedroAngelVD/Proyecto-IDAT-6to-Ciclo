package com.demo.model;

public class Alumno {

	private int id_alumno;
	private String cod_alumno;
	private String nombres_alumno;
	private String apellidos_alumno;
	private String grado;
	private String seccion;
	private String primsec;
	
	public Alumno() {
		super();
	}

	public Alumno(int id_alumno, String cod_alumno, String nombres_alumno, String apellidos_alumno, String grado,
			String seccion, String primsec) {
		super();
		this.id_alumno = id_alumno;
		this.cod_alumno = cod_alumno;
		this.nombres_alumno = nombres_alumno;
		this.apellidos_alumno = apellidos_alumno;
		this.grado = grado;
		this.seccion = seccion;
		this.primsec = primsec;
	}
	
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getCod_alumno() {
		return cod_alumno;
	}
	public void setCod_alumno(String cod_alumno) {
		this.cod_alumno = cod_alumno;
	}
	public String getNombres_alumno() {
		return nombres_alumno;
	}
	public void setNombres_alumno(String nombres_alumno) {
		this.nombres_alumno = nombres_alumno;
	}
	public String getApellidos_alumno() {
		return apellidos_alumno;
	}
	public void setApellidos_alumno(String apellidos_alumno) {
		this.apellidos_alumno = apellidos_alumno;
	}
	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getPrimsec() {
		return primsec;
	}
	public void setPrimsec(String primsec) {
		this.primsec = primsec;
	}
	
}
