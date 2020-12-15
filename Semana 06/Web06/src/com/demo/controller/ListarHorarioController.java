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

import com.demo.model.HorarioBuscar;
import com.demo.model.ListarHorario;
import com.demo.service.IListarHorarioService;

@Path("/listarHorario")
public class ListarHorarioController {

	@Inject
	private IListarHorarioService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ListarHorario> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public HorarioBuscar buscar(@PathParam("id") int id) {
		try {
			HorarioBuscar listarHorario = service.buscar(id);
			if(listarHorario == null)
				throw new WebApplicationException(404);
			return listarHorario;
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
		public ListarHorario update(ListarHorario listarHorario, @PathParam("id") int id ) {
			try {
				HorarioBuscar a =new HorarioBuscar();
				a.setId_curso_grado_detalle(id);
				return service.actualizar(listarHorario);
			} catch (Exception e) {
				throw new WebApplicationException(404);
			}
		}
		
}
