package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IProfesorDAO;
import com.demo.model.Profesor;

@Stateless
public class ProfesorDAOImpl implements IProfesorDAO{

public Conexion cx;
	
	public ProfesorDAOImpl() {
		cx = new Conexion();
	}

	@Override
	public Profesor guardar(Profesor profesor) {
		try {
			String sql = "{call sp_agregarProfesor(?,?,?,?,?,?,?)}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, profesor.getNombres());
			preparedStatement.setString(2, profesor.getApellidos());
			preparedStatement.setString(3, profesor.getDni());
			preparedStatement.setString(4, profesor.getDireccion());
			preparedStatement.setString(5, profesor.getTelefono());
			preparedStatement.setString(6, profesor.getCelular());
			preparedStatement.setString(7, profesor.getSexo());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (resultSet.next()) {
			    generatedKey = resultSet.getInt(1);
			}
			resultSet.close();
			profesor.setId_profesor(generatedKey);
			preparedStatement.close();
			return profesor;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Profesor actualizar(Profesor profesor) {
		try {
			String sql = "UPDATE tbl_profesor SET nombres = ?, apellidos = ?"
					+ ", direccion = ?, telefono = ?, celular = ?, sexo = ? WHERE id_profesor = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, profesor.getNombres());
			preparedStatement.setString(2, profesor.getApellidos());
			preparedStatement.setString(3, profesor.getDireccion());
			preparedStatement.setString(4, profesor.getTelefono());
			preparedStatement.setString(5, profesor.getCelular());
			preparedStatement.setString(6, profesor.getSexo());
			preparedStatement.setInt(7, profesor.getId_profesor());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return profesor;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Profesor> listar() {
		List<Profesor> profesor = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_profesor";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				profesor.add( new Profesor(
						resultSet.getInt("id_profesor"), 
						resultSet.getString("nombres"),
						resultSet.getString("apellidos"),
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
			profesor = new ArrayList<>();
		}
		return profesor;
	}

	@Override
	public Profesor buscarPorId(int id) {
		Profesor profesor = null;
		try {
			String sql = "SELECT * FROM tbl_profesor WHERE id_profesor = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				profesor = new Profesor(
						resultSet.getInt("id_profesor"), 
						resultSet.getString("nombres"),
						resultSet.getString("apellidos"),
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
		return profesor;
	}
	
	@Override
	public Profesor eliminarPorId(int id) {
		Profesor profesor =null;
		try {
			String sql = "DELETE FROM tbl_profesor WHERE id_profesor = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return profesor;
	}
	
}
