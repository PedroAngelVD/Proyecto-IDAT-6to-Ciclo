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

import com.demo.model.Curso;
import com.demo.service.ICursoService;

@Path("/curso")
public class CursoController {

	@Inject
	private ICursoService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Curso> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Curso buscar(@PathParam("id") int id) {
		try {
			Curso curso = service.buscar(id);
			if(curso == null)
				throw new WebApplicationException(404);
			return curso;
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
	public Curso save(Curso curso) {
		try {
			return service.registrar(curso);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Curso update(Curso curso, @PathParam("id") int id ) {
		try {
			curso.setId_curso(id);
			return service.actualizar(curso);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Curso delete(@PathParam("id") int id ) {
		try {
			return service.eliminar(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
}
