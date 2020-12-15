package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IDatosDAO;
import com.demo.model.Datos;
import com.demo.model.DatosCanAlumPrim;
import com.demo.model.DatosCanAlumSecu;
import com.demo.model.DatosCanMatriculaYear;
import com.demo.model.DatosCanMenMes;
import com.demo.model.DatosCanReinscripcionYear;

@Stateless
public class DatosDAOImpl implements IDatosDAO{

	public Conexion cx;
	
	public DatosDAOImpl() {
		cx = new Conexion();
	}

	@Override
	public List<Datos> listar() {
		List<Datos> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new Datos(
						resultSet.getInt("alumM"),
						resultSet.getInt("alumF")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}

	@Override
	public List<DatosCanAlumPrim> listarCAP() {
		List<DatosCanAlumPrim> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos_can_alumnosXgrado_Prim()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new DatosCanAlumPrim(
						resultSet.getInt("PrimeroPrim"),
						resultSet.getInt("SegundoPrim"),
						resultSet.getInt("TerceroPrim"),
						resultSet.getInt("CuartoPrim"),
						resultSet.getInt("QuintoPrim"),
						resultSet.getInt("SextoPrim")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}

	@Override
	public List<DatosCanAlumSecu> listarCAS() {
		List<DatosCanAlumSecu> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos_can_alumnosXgrado_Secu()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new DatosCanAlumSecu(
						resultSet.getInt("PrimeroSec"),
						resultSet.getInt("SegundoSec"),
						resultSet.getInt("TerceroSec"),
						resultSet.getInt("CuartoSec"),
						resultSet.getInt("QuintoSec")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}

	@Override
	public List<DatosCanMatriculaYear> listarCMY() {
		List<DatosCanMatriculaYear> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos_can_matriculasXYear()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new DatosCanMatriculaYear(
						resultSet.getInt("f2015M"),
						resultSet.getInt("f2016M"),
						resultSet.getInt("f2017M"),
						resultSet.getInt("f2018M"),
						resultSet.getInt("f2019M"),
						resultSet.getInt("f2020M")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}

	@Override
	public List<DatosCanMenMes> listarCMM() {
		List<DatosCanMenMes> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos_can_mensualidadXMes()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new DatosCanMenMes(
						resultSet.getInt("eneroMen"),
						resultSet.getInt("febreroMen"),
						resultSet.getInt("marzoMen"),
						resultSet.getInt("abrilMen"),
						resultSet.getInt("mayoMen"),
						resultSet.getInt("junioMen"),
						resultSet.getInt("julioMen"),
						resultSet.getInt("agostoMen"),
						resultSet.getInt("septiembreMen"),
						resultSet.getInt("octubreMen"),
						resultSet.getInt("noviembreMen"),
						resultSet.getInt("diciembreMen")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}

	@Override
	public List<DatosCanReinscripcionYear> listaCRY() {
		List<DatosCanReinscripcionYear> datos = new ArrayList<>();
		try {
			String sql = "{call sp_datos_can_reinscripcionXYear()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				datos.add( new DatosCanReinscripcionYear(
						resultSet.getInt("f2015R"),
						resultSet.getInt("f2016R"),
						resultSet.getInt("f2017R"),
						resultSet.getInt("f2018R"),
						resultSet.getInt("f2019R"),
						resultSet.getInt("f2020R")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			datos = new ArrayList<>();
		}
		return datos;
	}	
	
}
