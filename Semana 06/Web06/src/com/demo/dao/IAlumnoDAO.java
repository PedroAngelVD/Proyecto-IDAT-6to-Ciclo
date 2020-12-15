package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Alumno;

@Local
public interface IAlumnoDAO {

	Alumno actualizar(Alumno alumno);
	
	Alumno buscarPorId(int id);
	
	List<Alumno> listar();
	
}
