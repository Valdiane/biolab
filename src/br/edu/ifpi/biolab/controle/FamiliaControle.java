package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.FamiliaDao;
import br.edu.ifpi.biolab.entidade.Familia;

public class FamiliaControle {
	private FamiliaDao familiaDao;

	public FamiliaControle() throws SQLException {
		familiaDao = new FamiliaDao();

	}

	public void adiciona(Familia familia) throws SQLException {
		familiaDao.adiciona(familia);
		familiaDao.fechaConexao();

	}

	public List<Familia> buscaTodos() throws SQLException {
		List<Familia> familias = familiaDao.buscaTodos();
		familiaDao.fechaConexao();
		return familias;

	}

	public void altera(Familia familia) throws SQLException {
		familiaDao.altera(familia);
		familiaDao.fechaConexao();

	}

	public void remove(Familia familia) throws SQLException {
		familiaDao.remove(familia);
		familiaDao.fechaConexao();

	}
}
