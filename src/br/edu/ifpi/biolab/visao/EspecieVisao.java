package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.EspecieControle;
import br.edu.ifpi.biolab.entidade.Especie;

public class EspecieVisao {
	private EspecieControle especieControle;

	public EspecieVisao() throws SQLException {
		especieControle = new EspecieControle();
	}

	public void adiciona(Especie especie) throws SQLException {
		especieControle.adiciona(especie);
	}

	public List<Especie> buscaTodosEspecies() throws SQLException {
		List<Especie> especies = especieControle.buscaTodos();
		return especies;
	}

	public void altera(Especie especie) throws SQLException {
		especieControle.altera(especie);
	}

	public void remove(Especie especie) throws SQLException {
		especieControle.remove(especie);
	}

	public static void main(String[] args) throws SQLException {

		EspecieVisao visao = new EspecieVisao();
		int opcaoEscolhida = 1;

		while (opcaoEscolhida != 0) {

			String menu = "1 - Consultar\n 2-Adicionar\n 0-Sair";
			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			Especie f;
			switch (opcaoEscolhida) {

			case 1:
				List<Especie> especies = visao.buscaTodosEspecies();
				String especiesTela = "";
				JOptionPane.showMessageDialog(null, especies);
				for (Especie i : especies) {
					especiesTela = especiesTela + i.getId() + i.getNomeVulgar() + i.getNomeCientifico()
							+ i.getDataInclusao() + "\n";
				}

				JOptionPane.showMessageDialog(null, especiesTela);
				break;

			case 2:
				String nomeEspecie = JOptionPane.showInputDialog("Digite o nome do especie");
				f = new Especie(nomeEspecie);
				visao.adiciona(f);
				break;

			case 3:
				f = new Especie("Especie vv");
				visao.altera(f);
				break;

			case 4:
				f = new Especie("Especie vv");
				visao.remove(f);
				break;
			}
		}
	}

}
