package com.demo.service;

import java.util.List;

import com.demo.model.Matricula;

public interface IMatriculaService {


	Matricula registrar(Matricula matricula) throws Exception;
	
	Matricula actualizar(Matricula matricula) throws Exception;
	
	Matricula buscar(int id) throws Exception;
	
	List<Matricula> listarTodos() throws Exception;

	Matricula eliminar(int id) throws Exception;
	
}
