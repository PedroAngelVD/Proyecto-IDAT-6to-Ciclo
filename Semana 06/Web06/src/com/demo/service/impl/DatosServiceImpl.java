package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IDatosDAO;
import com.demo.model.Datos;
import com.demo.model.DatosCanAlumPrim;
import com.demo.model.DatosCanAlumSecu;
import com.demo.model.DatosCanMatriculaYear;
import com.demo.model.DatosCanMenMes;
import com.demo.model.DatosCanReinscripcionYear;
import com.demo.service.IDatosService;

@Named 
public class DatosServiceImpl implements IDatosService{

	@EJB
	private IDatosDAO dao;
	
	@Override
	public List<Datos> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public List<DatosCanAlumPrim> listarTodosCAP() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarCAP();
	}

	@Override
	public List<DatosCanAlumSecu> listarTodosCAS() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarCAS();
	}

	@Override
	public List<DatosCanMatriculaYear> listarTodosCMY() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarCMY();
	}

	@Override
	public List<DatosCanMenMes> listarTodosCMM() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarCMM();
	}

	@Override
	public List<DatosCanReinscripcionYear> listarTodosCRY() throws Exception {
		// TODO Auto-generated method stub
		return dao.listaCRY();
	}

}
