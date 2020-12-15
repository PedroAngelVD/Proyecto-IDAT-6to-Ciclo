package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IAlumnoDAO;
import com.demo.model.Alumno;
import com.demo.service.IAlumnoService;

@Named
public class AlumnoServiceImpl implements IAlumnoService {

	@EJB
	private IAlumnoDAO dao;
	
	@Override
	public Alumno actualizar(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(alumno);
	}

	@Override
	public Alumno buscar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public List<Alumno> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

}
