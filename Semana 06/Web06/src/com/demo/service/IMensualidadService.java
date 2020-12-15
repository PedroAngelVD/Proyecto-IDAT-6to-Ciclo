package com.demo.service;

import java.util.List;

import com.demo.model.Mensualidad;
import com.demo.model.PagoMensualidad;

public interface IMensualidadService {
	
	Mensualidad registrar(Mensualidad mensualidad) throws Exception;
	
	Mensualidad actualizar(Mensualidad mensualidad) throws Exception;
	
	Mensualidad buscar(int id) throws Exception;
	
	List<Mensualidad> listarTodos() throws Exception;

	Mensualidad eliminar(int id) throws Exception;

	List<PagoMensualidad> listarTodosPago() throws Exception;
}
