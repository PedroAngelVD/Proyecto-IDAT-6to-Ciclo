package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IReinscripcionDAO;
import com.demo.model.PagoReinscripcion;
import com.demo.model.Reinscripcion;
import com.demo.service.IReinscripcionService;

@Named
public class ReinscripcionServiceImpl implements IReinscripcionService{

	@EJB
	private IReinscripcionDAO dao;
	
	@Override
	public Reinscripcion registrar(Reinscripcion reinscripcion) throws Exception {
		// TODO Auto-generated method stub
		return dao.guardar(reinscripcion);
	}

	@Override
	public Reinscripcion actualizar(Reinscripcion reinscripcion) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(reinscripcion);
	}

	@Override
	public Reinscripcion buscar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public List<Reinscripcion> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Reinscripcion eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminarPorId(id);
	}

	@Override
	public List<PagoReinscripcion> listarTodosPago() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPago();
	}

}
