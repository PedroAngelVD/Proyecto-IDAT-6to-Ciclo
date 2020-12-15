package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.HorarioBuscar;
import com.demo.model.ListarHorario;

@Local
public interface IListarHorarioDAO {

	List<ListarHorario> listar();
	
	ListarHorario actualizar(ListarHorario listarHorario);
	
	HorarioBuscar buscarPorId(int id);
}
