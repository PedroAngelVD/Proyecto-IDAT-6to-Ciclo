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

import com.demo.model.Mensualidad;
import com.demo.model.PagoMensualidad;
import com.demo.service.IMensualidadService;

@Path("/mensualidad")
public class MensualidadController {

	@Inject
	private IMensualidadService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Mensualidad> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")//Tiene que ser el mismo nobre que el @PathParam("id")
	@Produces(MediaType.APPLICATION_JSON)
	public Mensualidad buscar(@PathParam("id") int id) {
		try {
			Mensualidad mensualidad = service.buscar(id);
			if(mensualidad == null)
				throw new WebApplicationException(404);
			return mensualidad;
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
	public Mensualidad save(Mensualidad mensualidad) {
		try {
			return service.registrar(mensualidad);
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensualidad update(Mensualidad mensualidad, @PathParam("id") int id ) {
		try {
			mensualidad.setId_hab_mensualidad(id);
			return service.actualizar(mensualidad);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensualidad delete(@PathParam("id") int id ) {
		try {
			return service.eliminar(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	@GET
	@Path("/pago")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<PagoMensualidad> listarPago() {
		try {
			return service.listarTodosPago();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
}
