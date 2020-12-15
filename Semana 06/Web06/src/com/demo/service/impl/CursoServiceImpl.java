package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.ICursoDAO;
import com.demo.model.Curso;
import com.demo.service.ICursoService;

@Named //permite dale un nombre a la implemnetacion
public class CursoServiceImpl implements ICursoService {

	@EJB
	private ICursoDAO dao;

	@Override
	public Curso registrar(Curso curso) throws Exception {
		return dao.guardar(curso);
	}

	@Override
	public Curso actualizar(Curso curso) throws Exception {
		return dao.actualizar(curso);
	}

	@Override
	public Curso buscar(int id) throws Exception {
		return dao.buscarPorId(id);
	}

	@Override
	public List<Curso> listarTodos() throws Exception {
		return dao.listar();
	}
	
	@Override
	public Curso eliminar(int id) throws Exception {
		return dao.eliminarPorId(id);
	}
	
}
