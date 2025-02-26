package br.com.projetocontas.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5433/bd_projetocontas";
	private static final String USER = "postgres";
	private static final String PASSWORD = "coti123";

	// Método para abri e retornar uma conexão com o banco de dados
	public static Connection getConnection() throws Exception { 
		Class.forName(DRIVER); 
	return DriverManager .getConnection(URL, USER, PASSWORD);
	
	}
}
