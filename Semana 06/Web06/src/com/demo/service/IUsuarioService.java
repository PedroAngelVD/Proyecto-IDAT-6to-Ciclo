package com.demo.service;

import java.util.List;

import com.demo.model.Usuario;

public interface IUsuarioService {

	List<Usuario> listarTodos() throws Exception;
}
