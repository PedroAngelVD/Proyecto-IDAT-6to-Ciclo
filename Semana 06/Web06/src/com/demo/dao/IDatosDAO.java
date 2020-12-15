package com.demo.dao;

import java.util.List;

import javax.ejb.Local;

import com.demo.model.Datos;
import com.demo.model.DatosCanAlumPrim;
import com.demo.model.DatosCanAlumSecu;
import com.demo.model.DatosCanMatriculaYear;
import com.demo.model.DatosCanMenMes;
import com.demo.model.DatosCanReinscripcionYear;

@Local 
public interface IDatosDAO {

	List<Datos> listar();
	
	List<DatosCanAlumPrim> listarCAP();
	
	List<DatosCanAlumSecu> listarCAS();
	
	List<DatosCanMatriculaYear> listarCMY();
	
	List<DatosCanMenMes> listarCMM();
	
	List<DatosCanReinscripcionYear> listaCRY();
}
