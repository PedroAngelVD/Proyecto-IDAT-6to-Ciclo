package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IMatriculaDAO;
import com.demo.model.Matricula;
import com.demo.service.IMatriculaService;

@Named
public class MatriculaServiceImpl implements IMatriculaService{

	@EJB
	private IMatriculaDAO dao;
	
	@Override
	public Matricula registrar(Matricula matricula) throws Exception {
		// TODO Auto-generated method stub
		return dao.guardar(matricula);
	}

	@Override
	public Matricula actualizar(Matricula matricula) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(matricula);
	}

	@Override
	public Matricula buscar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public List<Matricula> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Matricula eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminarPorId(id);
	}

}
