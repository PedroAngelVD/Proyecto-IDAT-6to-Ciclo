package com.demo.service;

import java.util.List;

import com.demo.model.Datos;
import com.demo.model.DatosCanAlumPrim;
import com.demo.model.DatosCanAlumSecu;
import com.demo.model.DatosCanMatriculaYear;
import com.demo.model.DatosCanMenMes;
import com.demo.model.DatosCanReinscripcionYear;

public interface IDatosService {

	List<Datos> listarTodos() throws Exception;
	
	List<DatosCanAlumPrim> listarTodosCAP() throws Exception;
	
	List<DatosCanAlumSecu> listarTodosCAS() throws Exception;
	
	List<DatosCanMatriculaYear> listarTodosCMY() throws Exception;
	
	List<DatosCanMenMes> listarTodosCMM() throws Exception;
	
	List<DatosCanReinscripcionYear> listarTodosCRY() throws Exception;
}
