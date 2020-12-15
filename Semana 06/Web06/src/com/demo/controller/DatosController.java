package com.demo.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.demo.model.Datos;
import com.demo.model.DatosCanAlumPrim;
import com.demo.model.DatosCanAlumSecu;
import com.demo.model.DatosCanMatriculaYear;
import com.demo.model.DatosCanMenMes;
import com.demo.model.DatosCanReinscripcionYear;
import com.demo.service.IDatosService;

@Path("/datos")
public class DatosController {

	@Inject
	private IDatosService service;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Datos> listar() {
		try {
			return service.listarTodos();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/CAP")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DatosCanAlumPrim> listarCAP() {
		try {
			return service.listarTodosCAP();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/CAS")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DatosCanAlumSecu> listarCAS() {
		try {
			return service.listarTodosCAS();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/CMY")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DatosCanMatriculaYear> listarCMY() {
		try {
			return service.listarTodosCMY();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/CMM")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DatosCanMenMes> listarCMM() {
		try {
			return service.listarTodosCMM();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
	@GET
	@Path("/CRY")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<DatosCanReinscripcionYear> listarCRY() {
		try {
			return service.listarTodosCRY();
		} catch (Exception e) {
			throw new WebApplicationException(403);
		}
	}
	
}
