package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IAlumnoDAO;
import com.demo.model.Alumno;

@Stateless
public class AlumnoDAOImpl implements IAlumnoDAO {

	public Conexion cx;
	
	public AlumnoDAOImpl() {
		cx = new Conexion();
	}
	
	@Override
	public Alumno actualizar(Alumno alumno) {
		try {
			String sql = "UPDATE tbl_alumno SET grado = ?, seccion = ?, primsec = ? WHERE id_alumno = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, alumno.getGrado());
			preparedStatement.setString(2, alumno.getSeccion());
			preparedStatement.setString(3, alumno.getPrimsec());
			preparedStatement.setInt(4, alumno.getId_alumno());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return alumno;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Alumno buscarPorId(int id) {
		Alumno alumno = null;
		try {
			String sql = "SELECT * FROM tbl_alumno WHERE id_alumno = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				alumno = new Alumno(
						resultSet.getInt("id_alumno"),
						resultSet.getString("cod_alumno"),
						resultSet.getString("nombres_alumno"),
						resultSet.getString("apellidos_alumno"),
						resultSet.getString("grado"),
						resultSet.getString("seccion"),
						resultSet.getString("primsec"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumno;
	}

	@Override
	public List<Alumno> listar() {
		List<Alumno> alumno = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_alumno";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				alumno.add( new Alumno(
						resultSet.getInt("id_alumno"),
						resultSet.getString("cod_alumno"),
						resultSet.getString("nombres_alumno"),
						resultSet.getString("apellidos_alumno"),
						resultSet.getString("grado"),
						resultSet.getString("seccion"),
						resultSet.getString("primsec")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			alumno = new ArrayList<>();
		}
		return alumno;
	}

}
