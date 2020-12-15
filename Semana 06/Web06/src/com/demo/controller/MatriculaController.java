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

import com.demo.model.Matricula;
import com.demo.service.IMatriculaService;

@Path("/matricula")
public class MatriculaController {

	@Inject
	private IMatriculaService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Matricula> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")//Tiene que ser el mismo nobre que el @PathParam("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Matricula buscar(@PathParam("id") int id) {
		try {
			Matricula matricula = service.buscar(id);
			if(matricula == null)
				throw new WebApplicationException(404);
			return matricula;
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
	public Matricula save(Matricula matricula) {
		try {
			return service.registrar(matricula);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Matricula update(Matricula matricula, @PathParam("id") int id ) {
		try {
			matricula.setId_matricula(id);
			return service.actualizar(matricula);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Matricula delete(@PathParam("id") int id ) {
		try {
			return service.eliminar(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
}
