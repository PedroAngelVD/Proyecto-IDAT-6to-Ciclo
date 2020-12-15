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

import com.demo.model.PagoReinscripcion;
import com.demo.model.Reinscripcion;
import com.demo.service.IReinscripcionService;

@Path("/reinscripcion")
public class ReinscripcionController {
	
	@Inject
	private IReinscripcionService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Reinscripcion> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")//Tiene que ser el mismo nobre que el @PathParam("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Reinscripcion buscar(@PathParam("id") int id) {
		try {
			Reinscripcion reinscripcion = service.buscar(id);
			if(reinscripcion == null)
				throw new WebApplicationException(404);
			return reinscripcion;
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
	public Reinscripcion save(Reinscripcion reinscripcion) {
		try {
			return service.registrar(reinscripcion);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reinscripcion update(Reinscripcion reinscripcion, @PathParam("id") int id ) {
		try {
			reinscripcion.setId_hab_reinscripcion(id);;
			return service.actualizar(reinscripcion);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Reinscripcion delete(@PathParam("id") int id ) {
		try {
			return service.eliminar(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@GET
	@Path("/pago")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PagoReinscripcion> listarPago() {
		try {
			return service.listarTodosPago();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}

}