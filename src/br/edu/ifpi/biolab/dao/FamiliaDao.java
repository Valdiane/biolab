package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Familia;

public class FamiliaDao extends Dao {

	public FamiliaDao() throws SQLException {

	}

	private Connection stmt;

	public void adiciona(Familia familia) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into familia (nome, id_ordem) values (?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, familia.getNome());
		stmt.setInt(2, familia.getOrdem().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Familia salva com sucesso");
		conexao.close();

	}

	public List<Familia> buscaTodos() throws SQLException {
		List<Familia> familia = new ArrayList<>();
		stmt = null;
		ResultSet rs = ((PreparedStatement) stmt).executeQuery();

		while (rs.next()) {
			Familia familia1 = new Familia(0, null, null);
			familia1.setId(rs.getInt("id"));
			familia1.setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return familia;
	}

	public Familia buscaPorId(int id) {
		return null;
	}

	public void altera(Familia familia) {
		String sql = "update familia set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, familia.getNome());
			stmt.setInt(2, familia.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Familia familia) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from familia where id=?");
			stmt.setInt(1, familia.getId());
			stmt.setString(2, familia.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
