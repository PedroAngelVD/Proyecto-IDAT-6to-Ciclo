package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Usuario;

@Local
public interface IUsuarioDAO {

	List<Usuario> listar();
}
