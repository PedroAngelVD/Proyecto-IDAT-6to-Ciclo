package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Matricula;

@Local
public interface IMatriculaDAO {

	 	Matricula guardar(Matricula matricula);
		
	 	Matricula actualizar(Matricula matricula);
		
	 	Matricula buscarPorId(int id);
		
		List<Matricula> listar();

		Matricula eliminarPorId(int id);
}
