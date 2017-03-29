package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Classe;

public class ClasseDao extends Dao {

	public ClasseDao() throws SQLException {

	}

	private Connection stmt;

	public void adiciona(Classe classe) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into classe (nome, id_filo) values (?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, classe.getNome());
		stmt.setInt(2, classe.getFilo().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Classe salva com sucesso");
		conexao.close();

	}

	public List<Classe> buscaTodos() throws SQLException {
		List<Classe> classe = new ArrayList<>();
		stmt = null;
		ResultSet rs = ((PreparedStatement) stmt).executeQuery();

		while (rs.next()) {
			Classe classe1 = new Classe(0, null, null);
			classe1.setId(rs.getInt("id"));
			classe1.setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return classe;
	}

	public Classe buscaPorId(int id) {
		return null;
	}

	public void altera(Classe classe) {
		String sql = "update classe set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, classe.getNome());
			stmt.setInt(2, classe.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void remove(Classe classe) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from classe where id=?");
			stmt.setInt(1, classe.getId());
			stmt.setString(2, classe.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
