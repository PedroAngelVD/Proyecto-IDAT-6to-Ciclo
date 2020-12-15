package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IProfesorDAO;
import com.demo.model.Profesor;
import com.demo.service.IProfesorService;

@Named
public class ProfesorServiceImpl implements IProfesorService {

	@EJB
	private IProfesorDAO dao;

	@Override
	public Profesor registrar(Profesor profesor) throws Exception {
		return dao.guardar(profesor);
	}

	@Override
	public Profesor actualizar(Profesor profesor) throws Exception {
		return dao.actualizar(profesor);
	}

	@Override
	public Profesor buscar(int id) throws Exception {
		return dao.buscarPorId(id);
	}

	@Override
	public List<Profesor> listarTodos() throws Exception {
		return dao.listar();
	}
	
	@Override
	public Profesor eliminar(int id) throws Exception {
		return dao.eliminarPorId(id);
	}
	
}
