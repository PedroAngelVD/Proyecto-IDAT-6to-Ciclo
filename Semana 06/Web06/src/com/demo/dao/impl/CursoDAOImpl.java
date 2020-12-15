package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.ICursoDAO;
import com.demo.model.Curso;

@Stateless
public class CursoDAOImpl implements ICursoDAO {

	public Conexion cx;
	
	public CursoDAOImpl() {
		cx = new Conexion();
	}

	@Override
	public Curso guardar(Curso curso) {
		try {
			String sql = "INSERT INTO tbl_curso(curso) VALUES(?)";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, curso.getCurso());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (resultSet.next()) {
			    generatedKey = resultSet.getInt(1);
			}
			resultSet.close();
			curso.setId_curso(generatedKey);
			preparedStatement.close();
			return curso;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Curso actualizar(Curso curso) {
		try {
			String sql = "UPDATE tbl_curso SET curso = ? WHERE id_curso = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, curso.getCurso());
			preparedStatement.setInt(2, curso.getId_curso());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return curso;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Curso> listar() {
		List<Curso> cursos = new ArrayList<>();
		try {
			String sql = "SELECT id_curso, curso FROM tbl_curso";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				cursos.add( new Curso(
						resultSet.getInt("id_curso"), 
						resultSet.getString("curso")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			cursos = new ArrayList<>();
		}
		return cursos;
	}

	@Override
	public Curso buscarPorId(int id) {
		Curso curso = null;
		try {
			String sql = "SELECT id_curso, curso FROM tbl_curso WHERE id_curso = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				curso = new Curso(
						resultSet.getInt("id_curso"), 
						resultSet.getString("curso"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}
	
	@Override
	public Curso eliminarPorId(int id) {
		Curso curso =null;
		try {
			String sql = "DELETE FROM tbl_curso WHERE id_curso = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}
	
}
