package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.OrdemDao;
import br.edu.ifpi.biolab.entidade.Ordem;

public class OrdemControle {
	private OrdemDao ordemDao;

	public OrdemControle() throws SQLException {
		ordemDao = new OrdemDao();

	}

	public void adiciona(Ordem ordem) throws SQLException {
		ordemDao.adiciona(ordem);
		ordemDao.fechaConexao();

	}

	public List<Ordem> buscaTodos() throws SQLException {
		List<Ordem> ordens = ordemDao.buscaTodos();
		ordemDao.fechaConexao();
		return ordens;

	}

	public void altera(Ordem ordem) throws SQLException {
		ordemDao.altera(ordem);
		ordemDao.fechaConexao();

	}

	public void remove(Ordem ordem) throws SQLException {
		ordemDao.remove(ordem);
		ordemDao.fechaConexao();

	}
}
