package com.demo.service;

import java.util.List;

import com.demo.model.Profesor;

public interface IProfesorService {

	Profesor registrar(Profesor profesor) throws Exception;
	
	Profesor actualizar(Profesor profesor) throws Exception;
	
	Profesor buscar(int id) throws Exception;
	
	List<Profesor> listarTodos() throws Exception;

	Profesor eliminar(int id) throws Exception;
	
}
