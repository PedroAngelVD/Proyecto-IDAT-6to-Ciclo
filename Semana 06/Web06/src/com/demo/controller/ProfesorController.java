package com.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.demo.model.Profesor;
import com.demo.service.IProfesorService;

@Path("/profesor")
public class ProfesorController {

	@Inject
	private IProfesorService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Profesor> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")//Tiene que ser el mismo nobre que el @PathParam("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Profesor buscar(@PathParam("id") int id) {
		try {
			Profesor profesor = service.buscar(id);
			if(profesor == null)
				throw new WebApplicationException(404);
			return profesor;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new WebApplicationException(500);
		}
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profesor save(Profesor profesor) {
		try {
			return service.registrar(profesor);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profesor update(Profesor profesor, @PathParam("id") int id ) {
		try {
			profesor.setId_profesor(id);
			return service.actualizar(profesor);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profesor delete(@PathParam("id") int id ) {
		try {
			return service.eliminar(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
}
