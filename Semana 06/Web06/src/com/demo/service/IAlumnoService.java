package com.demo.service;

import java.util.List;

import com.demo.model.Alumno;

public interface IAlumnoService {

	Alumno actualizar(Alumno alumno) throws Exception;
	
	Alumno buscar(int id) throws Exception;
	
	List<Alumno> listarTodos() throws Exception;
	
}
