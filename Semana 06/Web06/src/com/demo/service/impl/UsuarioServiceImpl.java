package com.demo.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.demo.dao.IUsuarioDAO;
import com.demo.model.Usuario;
import com.demo.service.IUsuarioService;

@Named
public class UsuarioServiceImpl implements IUsuarioService{

	@EJB
	private IUsuarioDAO dao;
	
	@Override
	public List<Usuario> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listar();
	}

}
