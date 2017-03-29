package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Genero;

public class GeneroDao extends Dao {

	public GeneroDao() throws SQLException {

	}

	private Connection stmt;

	public void adiciona(Genero genero) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into genero (nome, id_familia) values (?,?,?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, genero.getNome());
		stmt.setInt(2, genero.getFamilia().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Genero salva com sucesso");
		conexao.close();

	}

	public List<Genero> buscaTodos() throws SQLException {
		List<Genero> genero = new ArrayList<>();
		stmt = null;
		ResultSet rs = ((PreparedStatement) stmt).executeQuery();

		while (rs.next()) {
			Genero genero1 = new Genero(0, null, null);
			genero1.setId(rs.getInt("id"));
			genero1.setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return genero;
	}

	public Genero buscaPorId(int id) {
		return null;
	}

	public void altera(Genero genero) {
		String sql = "update genero set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, genero.getNome());
			stmt.setInt(2, genero.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Genero genero) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from genero where id=?");
			stmt.setInt(1, genero.getId());
			stmt.setString(2, genero.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
