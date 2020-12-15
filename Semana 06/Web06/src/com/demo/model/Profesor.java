package com.demo.model;

public class Profesor {
	
	private int id_profesor;
	private String nombres;
	private String apellidos;
	private String fec_registro;
	private String dni;
	private String direccion;
	private String telefono;
	private String celular;
	private String sexo;
	
	public Profesor() {
		super();
	}
	
	public Profesor(int id_profesor, String nombres, String apellidos, String fec_registro, String dni,
			String direccion, String telefono, String celular, String sexo) {
		super();
		this.id_profesor = id_profesor;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fec_registro = fec_registro;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.sexo = sexo;
	}
	
	public int getId_profesor() {
		return id_profesor;
	}
	public void setId_profesor(int id_profesor) {
		this.id_profesor = id_profesor;
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
	public String getFec_registro() {
		return fec_registro;
	}
	public void setFec_registro(String fec_registro) {
		this.fec_registro = fec_registro;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
