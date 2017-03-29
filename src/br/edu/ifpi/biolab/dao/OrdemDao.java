package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemDao extends Dao {

	public OrdemDao() throws SQLException {

	}

	private Connection stmt;

	public void adiciona(Ordem ordem) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into ordem (nome, id_classe) values (?,?,?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, ordem.getNome());
		stmt.setInt(2, ordem.getClasse().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Ordem salva com sucesso");
		conexao.close();

	}

	public List<Ordem> buscaTodos() throws SQLException {
		List<Ordem> ordem = new ArrayList<>();
		stmt = null;
		ResultSet rs = ((PreparedStatement) stmt).executeQuery();

		while (rs.next()) {
			Ordem ordem1 = new Ordem(0, null, null);
			ordem1.setId(rs.getInt("id"));
			ordem1.setNome(rs.getString("nome"));

		}
		rs.close();
		stmt.close();
		return ordem;
	}

	public Ordem buscaPorId(int id) {
		return null;
	}

	public void altera(Ordem ordem) {
		String sql = "update ordem set nome=?" + "where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, ordem.getNome());
			stmt.setInt(2, ordem.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Ordem ordem) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from ordem where id=?");
			stmt.setInt(1, ordem.getId());
			stmt.setString(2, ordem.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
