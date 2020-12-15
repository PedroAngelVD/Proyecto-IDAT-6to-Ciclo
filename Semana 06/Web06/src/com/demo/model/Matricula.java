package com.demo.model;

public class Matricula {

	private int id_matricula;
	private String numero_matricula;
	private String cod_alumno;
	private String nombres_alumno;
	private String apellidos_alumno;
	private String fec_nacimiento;
	private String fec_registro;
	private String dni;
	private String direccion;
	private String telefono;
	private String celular;
	private String sexo;
	
	public Matricula() {
		
	}

	public Matricula(int id_matricula, String numero_matricula, String cod_alumno, String nombres_alumno,
			String apellidos_alumno, String fec_nacimiento, String fec_registro, String dni, String direccion,
			String telefono, String celular, String sexo) {
		super();
		this.id_matricula = id_matricula;
		this.numero_matricula = numero_matricula;
		this.cod_alumno = cod_alumno;
		this.nombres_alumno = nombres_alumno;
		this.apellidos_alumno = apellidos_alumno;
		this.fec_nacimiento = fec_nacimiento;
		this.fec_registro = fec_registro;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.celular = celular;
		this.sexo = sexo;
	}
	
	public int getId_matricula() {
		return id_matricula;
	}
	public void setId_matricula(int id_matricula) {
		this.id_matricula = id_matricula;
	}
	public String getNumero_matricula() {
		return numero_matricula;
	}
	public void setNumero_matricula(String numero_matricula) {
		this.numero_matricula = numero_matricula;
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
	public String getFec_nacimiento() {
		return fec_nacimiento;
	}
	public void setFec_nacimiento(String fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
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
