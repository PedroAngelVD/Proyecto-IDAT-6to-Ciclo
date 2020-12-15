package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.PagoReinscripcion;
import com.demo.model.Reinscripcion;

@Local
public interface IReinscripcionDAO {

	Reinscripcion guardar(Reinscripcion reinscripcion);
	
	Reinscripcion actualizar(Reinscripcion reinscripcion);
	
	Reinscripcion buscarPorId(int id);
	
	List<Reinscripcion> listar();

	Reinscripcion eliminarPorId(int id);
	
	List<PagoReinscripcion> listarPago();
}
