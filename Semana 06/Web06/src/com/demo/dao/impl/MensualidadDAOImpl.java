package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IMensualidadDAO;
import com.demo.model.Mensualidad;
import com.demo.model.PagoMensualidad;

@Stateless
public class MensualidadDAOImpl implements IMensualidadDAO{

public Conexion cx;
	
	public MensualidadDAOImpl() {
		cx = new Conexion();
	}

	@Override
	public Mensualidad guardar(Mensualidad mensualidad) {
		try {
			String sql = "{call sp_habilitarMensualidad(?,?)}";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setDouble(1, mensualidad.getMonto());
			preparedStatement.setString(2, mensualidad.getVencimiento());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			int generatedKey = 0;
			if (resultSet.next()) {
			    generatedKey = resultSet.getInt(1);
			}
			resultSet.close();
			mensualidad.setId_hab_mensualidad(generatedKey);
			preparedStatement.close();
			return mensualidad;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public Mensualidad actualizar(Mensualidad mensualidad) {
		try {
			String sql = "UPDATE tbl_habilitar_mensualidad SET monto = ?, vencimiento = ? WHERE id_hab_mensualidad = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setDouble(1, mensualidad.getMonto());
			preparedStatement.setString(2, mensualidad.getVencimiento());
			preparedStatement.setInt(3, mensualidad.getId_hab_mensualidad());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return mensualidad;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Mensualidad> listar() {
		List<Mensualidad> mensualidad = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_habilitar_mensualidad";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				mensualidad.add( new Mensualidad(
						resultSet.getInt("id_hab_mensualidad"), 
						resultSet.getString("cod_mensualidad"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento"),
						resultSet.getString("codigo_reinscripcion")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			mensualidad = new ArrayList<>();
		}
		return mensualidad;
	}

	@Override
	public Mensualidad buscarPorId(int id) {
		Mensualidad mensualidad = null;
		try {
			String sql = "SELECT * FROM tbl_habilitar_mensualidad WHERE id_hab_mensualidad = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				mensualidad = new Mensualidad(
						resultSet.getInt("id_hab_mensualidad"), 
						resultSet.getString("cod_mensualidad"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento"),
						resultSet.getString("codigo_reinscripcion"));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensualidad;
	}
	
	@Override
	public Mensualidad eliminarPorId(int id) {
		Mensualidad mensualidad =null;
		try {
			String sql = "DELETE FROM tbl_habilitar_mensualidad WHERE id_hab_mensualidad = ?";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensualidad;
	}

	@Override
	public List<PagoMensualidad> listarPago() {
		List<PagoMensualidad> pagomensualidad = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_pago_mensualidad";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				pagomensualidad.add( new PagoMensualidad(
						resultSet.getInt("id_pago_mensualidad"), 
						resultSet.getString("cod_mensualidad"),
						resultSet.getString("descripcion"),
						resultSet.getDouble("monto"),
						resultSet.getString("vencimiento"),
						resultSet.getString("fecha"),
						resultSet.getString("cod_reinscripcion"),
						resultSet.getString("estado"),
						resultSet.getString("usuario")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			pagomensualidad = new ArrayList<>();
		}
		return pagomensualidad;
	}
	
}
