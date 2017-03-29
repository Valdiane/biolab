package br.edu.ifpi.biolab.controle;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpi.biolab.dao.GeneroDao;
import br.edu.ifpi.biolab.entidade.Genero;

public class GeneroControle {
	private GeneroDao generoDao;

	public void generoControle() throws SQLException {
		generoDao = new GeneroDao();

	}

	public void adiciona(Genero genero) throws SQLException {
		generoDao.adiciona(genero);
		generoDao.fechaConexao();

	}

	public List<Genero> buscaTodos() throws SQLException {
		List<Genero> generos = generoDao.buscaTodos();
		generoDao.fechaConexao();
		return generos;

	}

	public void altera(Genero genero) throws SQLException {
		generoDao.altera(genero);
		generoDao.fechaConexao();

	}

	public void remove(Genero genero) throws SQLException {
		generoDao.remove(genero);
		generoDao.fechaConexao();

	}

}
