package br.edu.ifpi.biolab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifpi.biolab.entidade.Especie;

public class EspecieDao extends Dao {

	public EspecieDao() throws SQLException {

	}

	public void adiciona(Especie especie) throws SQLException {
		Connection conexao = ConnectFactory.getConexao();

		String sql = "insert into especie (nome_vulgar, nome_cientifico, data_inclusao, id_genero) values (?,?,?,?)";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, especie.getNomeVulgar());
		stmt.setString(2, especie.getNomeCientifico());
		stmt.setDate(3, new java.sql.Date(especie.getDataInclusao().getTime()));
		stmt.setInt(4, especie.getGenero().getId());

		stmt.execute();
		stmt.close();
		System.out.println("Especie salva com sucesso");
		conexao.close();

	}

	public List<Especie> buscaTodos() throws SQLException {
		List<Especie> especies = new ArrayList<>();
		Connection conexao = ConnectFactory.getConexao();
		PreparedStatement stmt = conexao.prepareStatement("select * from especie");
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Especie especie = new Especie();
			especie.setId(rs.getInt("id"));
			especie.setNomeVulgar(rs.getString("nome_vulgar"));
			especie.setNomeCientifico(rs.getString("nome_cientifico"));

			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("data_inclusao"));
			especie.setDataInclusao(data.getTime());

			especies.add(especie);
		}
		rs.close();
		stmt.close();
		return especies;
	}

	public Especie buscaPorId(int id) {
		return null;
	}

	public void altera(Especie especie) {
		String sql = "update especie set nomeVulgar=?," + "nomeCientifico=?, dataInclusao=? where id=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, especie.getNomeVulgar());
			stmt.setString(2, especie.getNomeCientifico());
			stmt.setDate(3, (Date) especie.getDataInclusao());
			stmt.setInt(4, especie.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Especie especie) {
		try {
			PreparedStatement stmt = getConexao().prepareStatement("delete" + "from especie where id=?");
			stmt.setInt(1, especie.getId());
			stmt.setString(2, especie.getNomeVulgar());
			stmt.setString(3, especie.getNomeCientifico());
			stmt.setDate(4, (Date) especie.getDataInclusao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
