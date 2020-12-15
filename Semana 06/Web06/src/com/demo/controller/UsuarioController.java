package com.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.demo.model.Usuario;
import com.demo.service.IUsuarioService;

@Path("/usuario")
public class UsuarioController {

	@Inject
	private IUsuarioService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Usuario> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
}
