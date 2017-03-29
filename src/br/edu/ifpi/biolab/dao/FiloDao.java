package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Classe;
import br.edu.ifpi.biolab.entidade.Filo;

public class FiloDao extends Dao {

	public FiloDao() throws SQLException {

	}

	private Connection stmt;

	public void adiciona(Filo filo) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into classe (nome, id_reino) values (?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, filo.getNome());
		stmt.setInt(2, filo.getReino().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Filo salva com sucesso");
		conexao.close();

	}

	public List<Filo> buscaTodos() throws SQLException {
		List<Filo> filo = new ArrayList<>();
		stmt = null;
		ResultSet rs = ((PreparedStatement) stmt).executeQuery();

		while (rs.next()) {
			((Classe) filo).setId(rs.getInt("id"));
			((Classe) filo).setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return filo;
	}

	public Classe buscaPorId(int id) {
		return null;
	}

	public void altera(Filo filo) {
		String sql = "update filo set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, filo.getNome());
			stmt.setInt(5, filo.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Filo filo) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from filo where id=?");
			stmt.setInt(1, filo.getId());
			stmt.setString(2, filo.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
