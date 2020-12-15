package com.demo.model;

public class HorarioBuscar {

	private int id_curso_grado_detalle;
	private int id_curso_profesor;
	private int id_grado_seccion;
	private String horario_inicio;
	private String horario_fin;
	
	public HorarioBuscar() {
		super();
	}	
	
	public HorarioBuscar(int id_curso_grado_detalle, int id_curso_profesor, int id_grado_seccion, String horario_inicio,
			String horario_fin) {
		super();
		this.id_curso_grado_detalle = id_curso_grado_detalle;
		this.id_curso_profesor = id_curso_profesor;
		this.id_grado_seccion = id_grado_seccion;
		this.horario_inicio = horario_inicio;
		this.horario_fin = horario_fin;
	}

	public int getId_curso_grado_detalle() {
		return id_curso_grado_detalle;
	}

	public void setId_curso_grado_detalle(int id_curso_grado_detalle) {
		this.id_curso_grado_detalle = id_curso_grado_detalle;
	}

	public int getId_curso_profesor() {
		return id_curso_profesor;
	}

	public void setId_curso_profesor(int id_curso_profesor) {
		this.id_curso_profesor = id_curso_profesor;
	}

	public int getId_grado_seccion() {
		return id_grado_seccion;
	}

	public void setId_grado_seccion(int id_grado_seccion) {
		this.id_grado_seccion = id_grado_seccion;
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
