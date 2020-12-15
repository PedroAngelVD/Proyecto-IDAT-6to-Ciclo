package com.demo.dao;

import java.util.List;

import com.demo.model.Curso;

import javax.ejb.Local;

@Local
public interface ICursoDAO {

	Curso guardar(Curso curso);
	
	Curso actualizar(Curso curso);
	
	Curso buscarPorId(int id);
	
	List<Curso> listar();

	Curso eliminarPorId(int id);
	
}
