package com.demo.service;

import java.util.List;

import com.demo.model.Curso;

public interface ICursoService {

	Curso registrar(Curso curso) throws Exception;
	
	Curso actualizar(Curso curso) throws Exception;
	
	Curso buscar(int id) throws Exception;
	
	List<Curso> listarTodos() throws Exception;

	Curso eliminar(int id) throws Exception;
}
	

