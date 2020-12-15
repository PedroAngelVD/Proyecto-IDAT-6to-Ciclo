package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IMensualidadDAO;
import com.demo.model.Mensualidad;
import com.demo.model.PagoMensualidad;
import com.demo.service.IMensualidadService;

@Named
public class MensualidadServiceImpl implements IMensualidadService{

	@EJB
	private IMensualidadDAO dao;
	
	@Override
	public Mensualidad registrar(Mensualidad mensualidad) throws Exception {
		// TODO Auto-generated method stub
		return dao.guardar(mensualidad);
	}

	@Override
	public Mensualidad actualizar(Mensualidad mensualidad) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(mensualidad);
	}

	@Override
	public Mensualidad buscar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.buscarPorId(id);
	}

	@Override
	public List<Mensualidad> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

	@Override
	public Mensualidad eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminarPorId(id);
	}

	@Override
	public List<PagoMensualidad> listarTodosPago() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarPago();
	}

}
