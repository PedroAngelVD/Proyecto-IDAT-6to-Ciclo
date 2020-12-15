package com.demo.model;

public class Curso {

	private int id_curso;
    private String curso;
    
	public Curso() {
		super();
	}
	
	public Curso(int id_curso, String curso) {
		super();
		this.id_curso = id_curso;
		this.curso = curso;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
}
