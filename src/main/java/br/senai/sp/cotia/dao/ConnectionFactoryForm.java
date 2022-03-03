package br.senai.sp.cotia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryForm {

	public static final String USUARIO = "root";
	public static final String SENHA = "";
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost/clientesdatabase", USUARIO, SENHA);
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
