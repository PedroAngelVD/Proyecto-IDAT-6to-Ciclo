package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Mensualidad;
import com.demo.model.PagoMensualidad;

@Local
public interface IMensualidadDAO {

	Mensualidad guardar(Mensualidad mensualidad);
	
	Mensualidad actualizar(Mensualidad mensualidad);
	
	Mensualidad buscarPorId(int id);
	
	List<Mensualidad> listar();

	Mensualidad eliminarPorId(int id);
	
	List<PagoMensualidad> listarPago();
}
