package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectFactory {

	public static Connection getConexao() throws SQLException {

		return DriverManager.getConnection("jdbc:mysql://10.0.30.81/valdiane_sayonara_biolab", "aluno", "aluno");

	}
}