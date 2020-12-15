package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Profesor;

@Local
public interface IProfesorDAO {

    Profesor guardar(Profesor profesor);
	
    Profesor actualizar(Profesor profesor);
	
    Profesor buscarPorId(int id);
	
	List<Profesor> listar();

	Profesor eliminarPorId(int id);
	
}
