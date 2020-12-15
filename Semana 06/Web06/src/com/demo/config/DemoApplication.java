package com.demo.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.demo.controller.AlumnoController;
import com.demo.controller.CursoController;
import com.demo.controller.DatosController;
import com.demo.controller.ListarHorarioController;
import com.demo.controller.MatriculaController;
import com.demo.controller.MensualidadController;
import com.demo.controller.ProfesorController;
import com.demo.controller.ReinscripcionController;
import com.demo.controller.UsuarioController;

@ApplicationPath("rest")
public class DemoApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CursoController.class);
		classes.add(ProfesorController.class);
		classes.add(UsuarioController.class);
		classes.add(MatriculaController.class);
		classes.add(MensualidadController.class);
		classes.add(ReinscripcionController.class);
		classes.add(ListarHorarioController.class);
		classes.add(AlumnoController.class);
		classes.add(DatosController.class);
		return classes;
	}
	
}
