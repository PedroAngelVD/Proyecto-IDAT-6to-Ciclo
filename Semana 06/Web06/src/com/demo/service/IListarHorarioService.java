package com.demo.service;

import java.util.List;

import com.demo.model.HorarioBuscar;
import com.demo.model.ListarHorario;

public interface IListarHorarioService {

	List<ListarHorario> listarTodos() throws Exception;
	
	ListarHorario actualizar(ListarHorario listarHorario) throws Exception;
	
	HorarioBuscar buscar(int id) throws Exception;
}
