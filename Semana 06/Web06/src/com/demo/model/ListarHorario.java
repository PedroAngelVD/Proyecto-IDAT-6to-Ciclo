package com.demo.model;

public class ListarHorario {
	private int id_curso_grado_detalle;
	private String curso;
	private String nombres;
	private String apellidos;
	private String grado;
	private String seccion;
	private String primsec;
	private String horario_inicio;
	private String horario_fin;
	
	public ListarHorario() {
		super();
	}
	
	public ListarHorario(int id_curso_grado_detalle, String curso, String nombres, String apellidos, String grado,
			String seccion, String primsec, String horario_inicio, String horario_fin) {
		super();
		this.id_curso_grado_detalle = id_curso_grado_detalle;
		this.curso = curso;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.grado = grado;
		this.seccion = seccion;
		this.primsec = primsec;
		this.horario_inicio = horario_inicio;
		this.horario_fin = horario_fin;
	}
	
	public int getId_curso_grado_detalle() {
		return id_curso_grado_detalle;
	}
	public void setId_curso_grado_detalle(int id_curso_grado_detalle) {
		this.id_curso_grado_detalle = id_curso_grado_detalle;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
	public String getHorario_inicio() {
		return horario_inicio;
	}
	public void setHorario_inicio(String horario_inicio) {
		this.horario_inicio = horario_inicio;
	}
	public String getHorario_fin() {
		return horario_fin;
	}
	public void setHorario_fin(String horario_fin) {
		this.horario_fin = horario_fin;
	}
	
}
