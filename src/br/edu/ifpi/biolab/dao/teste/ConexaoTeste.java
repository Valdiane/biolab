package br.edu.ifpi.biolab.dao.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.ifpi.biolab.dao.ConnectFactory;

public class ConexaoTeste {
	public static void main(String[] args) throws SQLException {

		Connection conexao = ConnectFactory.getConexao();

		System.out.println("Conexão aberta!");
		conexao.close();

	}
}
