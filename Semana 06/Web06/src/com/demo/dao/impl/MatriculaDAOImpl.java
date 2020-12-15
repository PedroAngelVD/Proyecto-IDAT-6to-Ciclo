package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IMatriculaDAO;
import com.demo.model.Matricula;

@Stateless
public class MatriculaDAOImpl implements IMatriculaDAO {

public Conexion cx;
	
	public MatriculaDAOImpl() {
		cx = new Conexion();
	}
	
	@Override
	public Matricula guardar(Matricula matricula) {
		try {
			String sql = "{call sp_generarMatricula(?,?,?,?,?,?,?,?)}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, matricula.getNombres_alumno());
			preparedStatement.setString(2, matricula.getApellidos_alumno());
			preparedStatement.setString(3, matricula.getFec_nacimiento());
			preparedStatement.setString(4, matricula.getDni());
			preparedStatement.setString(5, matricula.getDireccion());
			preparedStatement.setString(6, matricula.getTelefono());
			preparedStatement.setString(7, matricula.getCelular());
			preparedStatement.setString(8, matricula.getSexo());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (resultSet.next()) {
			    generatedKey = resultSet.getInt(1);
			}
			resultSet.close();
			matricula.setId_matricula(generatedKey);
			preparedStatement.close();
			return matricula;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Matricula actualizar(Matricula matricula) {
		try {
			String sql = "UPDATE tbl_matricula SET nombres_alumno = ?, apellidos_alumno = ?"
					+ ", direccion = ?, telefono = ?, celular = ?, sexo = ? WHERE id_matricula = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, matricula.getNombres_alumno());
			preparedStatement.setString(2, matricula.getApellidos_alumno());
			preparedStatement.setString(3, matricula.getDireccion());
			preparedStatement.setString(4, matricula.getTelefono());
			preparedStatement.setString(5, matricula.getCelular());
			preparedStatement.setString(6, matricula.getSexo());
			preparedStatement.setInt(7, matricula.getId_matricula());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return matricula;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Matricula buscarPorId(int id) {
		Matricula matricula = null;
		try {
			String sql = "SELECT * FROM tbl_matricula WHERE id_matricula = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				matricula = new Matricula(
						resultSet.getInt("id_matricula"),
						resultSet.getString("numero_matricula"),
						resultSet.getString("cod_alumno"),
						resultSet.getString("nombres_alumno"),
						resultSet.getString("apellidos_alumno"),
						resultSet.getString("fec_nacimiento"),
						resultSet.getString("fec_registro"),
						resultSet.getString("dni"),
						resultSet.getString("direccion"),
						resultSet.getString("telefono"),
						resultSet.getString("celular"),
						resultSet.getString("sexo"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matricula;
	}

	@Override
	public List<Matricula> listar() {
		List<Matricula> matricula = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_matricula";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				matricula.add( new Matricula(
						resultSet.getInt("id_matricula"),
						resultSet.getString("numero_matricula"),
						resultSet.getString("cod_alumno"),
						resultSet.getString("nombres_alumno"),
						resultSet.getString("apellidos_alumno"),
						resultSet.getString("fec_nacimiento"),
						resultSet.getString("fec_registro"),
						resultSet.getString("dni"),
						resultSet.getString("direccion"),
						resultSet.getString("telefono"),
						resultSet.getString("celular"),
						resultSet.getString("sexo")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			matricula = new ArrayList<>();
		}
		return matricula;
	}

	@Override
	public Matricula eliminarPorId(int id) {
		Matricula matricula =null;
		try {
			String sql = "DELETE FROM tbl_matricula WHERE id_matricula = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return matricula;
	}

}
