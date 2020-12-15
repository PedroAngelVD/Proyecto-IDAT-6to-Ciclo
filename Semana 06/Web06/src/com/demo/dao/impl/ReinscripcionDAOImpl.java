package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IReinscripcionDAO;
import com.demo.model.PagoReinscripcion;
import com.demo.model.Reinscripcion;

@Stateless
public class ReinscripcionDAOImpl implements IReinscripcionDAO{
	
	public Conexion cx;
	
	public ReinscripcionDAOImpl() {
		cx = new Conexion();
	}
	
	@Override
	public Reinscripcion guardar(Reinscripcion reinscripcion) {
		try {
			String sql = "{call sp_habilitarReinscripcion(?,?,?)}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, reinscripcion.getDescripcion());
			preparedStatement.setDouble(2, reinscripcion.getMonto());
			preparedStatement.setString(3, reinscripcion.getVencimiento());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (resultSet.next()) {
			    generatedKey = resultSet.getInt(1);
			}
			resultSet.close();
			reinscripcion.setId_hab_reinscripcion(generatedKey);
			preparedStatement.close();
			return reinscripcion;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Reinscripcion actualizar(Reinscripcion reinscripcion) {
		try {
			String sql = "UPDATE tbl_habilitar_reinscripcion SET descripcion = ?, monto = ?"
					+ ", vencimiento = ? WHERE id_hab_reinscripcion = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setString(1, reinscripcion.getDescripcion());
			preparedStatement.setDouble(2, reinscripcion.getMonto());
			preparedStatement.setString(3, reinscripcion.getVencimiento());
			preparedStatement.setInt(4, reinscripcion.getId_hab_reinscripcion());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return reinscripcion;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Reinscripcion buscarPorId(int id) {
		Reinscripcion reinscripcion = null;
		try {
			String sql = "SELECT * FROM tbl_habilitar_reinscripcion WHERE id_hab_reinscripcion = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				reinscripcion = new Reinscripcion(
						resultSet.getInt("id_hab_reinscripcion"),
						resultSet.getString("cod_reinscripcion"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reinscripcion;
	}

	@Override
	public List<Reinscripcion> listar() {
		List<Reinscripcion> reinscripcion = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_habilitar_reinscripcion";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				reinscripcion.add( new Reinscripcion(
						resultSet.getInt("id_hab_reinscripcion"),
						resultSet.getString("cod_reinscripcion"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			reinscripcion = new ArrayList<>();
		}
		return reinscripcion;
	}

	@Override
	public Reinscripcion eliminarPorId(int id) {
		Reinscripcion reinscripcion =null;
		try {
			String sql = "DELETE FROM tbl_habilitar_reinscripcion WHERE id_hab_reinscripcion = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reinscripcion;
	}

	@Override
	public List<PagoReinscripcion> listarPago() {
		List<PagoReinscripcion> pagoreinscripcion = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_pago_reinscripcion";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pagoreinscripcion.add( new PagoReinscripcion(
						resultSet.getInt("id_pago_reinscripcion"),
						resultSet.getString("cod_reinscripcion"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento"),
						resultSet.getString("fecha"),
						resultSet.getString("estado"),
						resultSet.getString("usuario")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pagoreinscripcion = new ArrayList<>();
		}
		return pagoreinscripcion;
	}

}
