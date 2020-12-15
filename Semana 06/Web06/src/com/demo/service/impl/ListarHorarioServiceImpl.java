package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IListarHorarioDAO;
import com.demo.model.HorarioBuscar;
import com.demo.model.ListarHorario;
import com.demo.service.IListarHorarioService;

@Named
public class ListarHorarioServiceImpl implements IListarHorarioService {

	@EJB
	private IListarHorarioDAO dao;

	@Override
	public List<ListarHorario> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public ListarHorario actualizar(ListarHorario listarHorario) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(listarHorario);
	}

	@Override
	public HorarioBuscar buscar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}
	
}
