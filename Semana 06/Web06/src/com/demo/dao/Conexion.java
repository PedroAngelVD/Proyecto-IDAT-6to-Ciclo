package com.demo.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	String ConxDB="jdbc:mysql://localhost/db_colegio_2";
    String UserDB="root";
    String PassDB="";
    String JdbcDB="com.mysql.jdbc.Driver";
    Connection Conexion;

    public Conexion() {
        try{
            Class.forName(JdbcDB);
            Conexion = DriverManager.getConnection(ConxDB,UserDB,PassDB);
                if(Conexion!=null){
                    DatabaseMetaData dm=(DatabaseMetaData) Conexion.getMetaData();
                    System.out.println("Mi base de datos : "+dm);
                }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            }  
    }
    
    public Connection getConexion(){
            return this.Conexion;
        } 

    public static void main(String[]args){
        Conexion cn=new Conexion();
    }
	
}
