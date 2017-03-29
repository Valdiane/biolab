package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.FiloDao;
import br.edu.ifpi.biolab.entidade.Filo;

public class FiloControle {
	private FiloDao filoDao;

	public FiloControle() throws SQLException {
		filoDao = new FiloDao();

	}

	public void adiciona(Filo filo) throws SQLException {
		filoDao.adiciona(filo);
		filoDao.fechaConexao();

	}

	public List<Filo> buscaTodos() throws SQLException {
		List<Filo> filos = filoDao.buscaTodos();
		filoDao.fechaConexao();
		return filos;

	}

	public void altera(Filo filo) throws SQLException {
		filoDao.altera(filo);
		filoDao.fechaConexao();

	}

	public void remove(Filo filo) throws SQLException {
		filoDao.remove(filo);
		filoDao.fechaConexao();

	}
}
