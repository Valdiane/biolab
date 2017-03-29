package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.GeneroControle;
import br.edu.ifpi.biolab.entidade.Genero;

public class GeneroVisao {
	private GeneroControle generoControle;

	public GeneroVisao() throws SQLException {
		generoControle = new GeneroControle();
	}

	public void adiciona(Genero genero) throws SQLException {
		generoControle.adiciona(genero);
	}
	public List<Genero> buscaTodosGeneros() throws SQLException {
		List<Genero> generos = generoControle.buscaTodos();
		return generos;
	}

	public void altera(Genero genero) throws SQLException {
		generoControle.altera(genero);
	}

	public void remove(Genero genero) throws SQLException {
		generoControle.remove(genero);
	}

	public static void main(String[] args) throws SQLException {

		GeneroVisao visao = new GeneroVisao();
		int opcaoEscolhida = 1;

		while (opcaoEscolhida != 0) {

			String menu = "1 - Consultar\n 2-Adicionar\n 0-Sair";
			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			Genero g;
			switch (opcaoEscolhida) {

			case 1:
				List<Genero> generos = visao.buscaTodosGeneros();
				String generosTela = "";
				JOptionPane.showMessageDialog(null, generos);
				for (Genero i : generos) {
					generosTela = generosTela + i.getId() + i.getNome() + "\n";
				}

				JOptionPane.showMessageDialog(null, generosTela);
				break;

			case 2:
				String nomeGenero = JOptionPane.showInputDialog("Digite o nome do genero");
				g = new Genero(nomeGenero);
				visao.adiciona(g);
				break;

			case 3:
				g = new Genero("Genero vv");
				visao.altera(g);
				break;
				
			case 4:
				g = new Genero("Genero vv");
				visao.remove(g);
				break;
			}
		}
	}

}
