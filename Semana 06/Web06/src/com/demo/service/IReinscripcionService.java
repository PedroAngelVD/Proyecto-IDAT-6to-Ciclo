package com.demo.service;

import java.util.List;

import com.demo.model.PagoReinscripcion;
import com.demo.model.Reinscripcion;

public interface IReinscripcionService {

	Reinscripcion registrar(Reinscripcion reinscripcion) throws Exception;
	
	Reinscripcion actualizar(Reinscripcion reinscripcion) throws Exception;
	
	Reinscripcion buscar(int id) throws Exception;
	
	List<Reinscripcion> listarTodos() throws Exception;

	Reinscripcion eliminar(int id) throws Exception;
	
	List<PagoReinscripcion> listarTodosPago() throws Exception;
}
