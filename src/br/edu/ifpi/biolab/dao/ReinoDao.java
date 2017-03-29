package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Reino;

public class ReinoDao extends Dao {

	public ReinoDao() throws SQLException {

	}

	public void adiciona(Reino reino) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into reino (nome) values (?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, "Fungi");

		stmt.execute();
		stmt.close();

		System.out.println("Reino salvo com sucesso");
		conexao.close();
	}

	public List<Reino> buscaTodos1() throws SQLException {
		List<Reino> reino = new ArrayList<>();
		Connection conexao = ConnectFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from reino");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Reino reinos = new Reino(null);
			reinos.setId(rs.getInt("id"));
			reinos.setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return reino;
	}

	public void altera(Reino reino) {
		String sql = "update reino set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, reino.getNome());
			stmt.setInt(2, reino.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Reino reino) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from reino where id=?");
			stmt.setInt(1, reino.getId());
			stmt.setString(2, reino.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reino> buscaTodos() {

		return null;
	}

}
