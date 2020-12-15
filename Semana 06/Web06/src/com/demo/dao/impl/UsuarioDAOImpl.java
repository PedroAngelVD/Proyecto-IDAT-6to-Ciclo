package com.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.demo.dao.Conexion;
import com.demo.dao.IUsuarioDAO;
import com.demo.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO{

public Conexion cx;
	
	public UsuarioDAOImpl() {
		cx = new Conexion();
	}
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuario = new ArrayList<>();
		try {
			String sql = "SELECT * FROM tbl_usuario";
			
			Connection cn = cx.getConexion();
			
			PreparedStatement preparedStatement = cn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				usuario.add( new Usuario(
						resultSet.getInt("id_usuario"), 
						resultSet.getString("usuario"),
						resultSet.getString("password"),
						resultSet.getString("rol")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			usuario = new ArrayList<>();
		}
		return usuario;
	}

}
