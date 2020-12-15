package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IListarHorarioDAO;
import com.demo.model.HorarioBuscar;
import com.demo.model.ListarHorario;

@Stateless 
public class ListarHorarioDAOImpl implements IListarHorarioDAO{

public Conexion cx;
	
	public ListarHorarioDAOImpl() {
		cx = new Conexion();
	}

	@Override
	public List<ListarHorario> listar() {
		List<ListarHorario> listar = new ArrayList<>();
		try {
			String sql = "{call sp_listar_horarios()}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listar.add( new ListarHorario(
						resultSet.getInt("id_curso_grado_detalle"), 
						resultSet.getString("curso"),
						resultSet.getString("nombres"),
						resultSet.getString("apellidos"),
						resultSet.getString("grado"),
						resultSet.getString("seccion"),
						resultSet.getString("primsec"),
						resultSet.getString("horario_inicio"),
						resultSet.getString("horario_fin")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			listar = new ArrayList<>();
		}
		return listar;
	}

	@Override
	public ListarHorario actualizar(ListarHorario listarHorario) {
		try {
			String sql = "UPDATE tbl_curso_grado_detalle SET horario_inicio = ?, horario_fin = ?"
					+ " WHERE id_curso_grado_detalle = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, listarHorario.getHorario_inicio());
			preparedStatement.setString(2, listarHorario.getHorario_fin());
			preparedStatement.setInt(3, listarHorario.getId_curso_grado_detalle());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return listarHorario;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public HorarioBuscar buscarPorId(int id) {
		HorarioBuscar listarHorario = null;
		try {
			String sql = "SELECT * FROM tbl_curso_grado_detalle WHERE id_curso_grado_detalle = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				listarHorario = new HorarioBuscar(
						resultSet.getInt("id_curso_grado_detalle"), 
						resultSet.getInt("id_curso_profesor"), 
						resultSet.getInt("id_grado_seccion"), 
						resultSet.getString("horario_inicio"),
						resultSet.getString("horario_fin"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarHorario;
	}
	
}
