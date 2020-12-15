package com.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.demo.model.Alumno;
import com.demo.service.IAlumnoService;

@Path("/alumno")
public class AlumnoController {

	@Inject
	private IAlumnoService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Alumno> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Alumno buscar(@PathParam("id") int id) {
		try {
			Alumno alumno = service.buscar(id);
			if(alumno == null)
				throw new WebApplicationException(404);
			return alumno;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alumno update(Alumno alumno, @PathParam("id") int id ) {
		try {
			alumno.setId_alumno(id);
			return service.actualizar(alumno);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
}
