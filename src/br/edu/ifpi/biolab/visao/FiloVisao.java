package br.edu.ifpi.biolab.visao;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.ifpi.biolab.controle.FiloControle;
import br.edu.ifpi.biolab.entidade.Filo;

public class FiloVisao {

	private FiloControle filoControle;

	public FiloVisao() throws SQLException {
		filoControle = new FiloControle();
	}

	public void adiciona(Filo filo) throws SQLException {
		filoControle.adiciona(filo);
	}
	public List<Filo> buscaTodosFilos() throws SQLException {
		List<Filo> filos = filoControle.buscaTodos();
		return filos;
	}

	public void altera(Filo filo) throws SQLException {
		filoControle.altera(filo);
	}

	public void remove(Filo filo) throws SQLException {
		filoControle.remove(filo);
	}

	public static void main(String[] args) throws SQLException {

		FiloVisao visao = new FiloVisao();
		int opcaoEscolhida = 1;

		while (opcaoEscolhida != 0) {

			String menu = "1 - Consultar\n 2-Adicionar\n 0-Sair";
			String valorDigitado = JOptionPane.showInputDialog(menu);
			opcaoEscolhida = Integer.parseInt(valorDigitado);
			Filo f;
			switch (opcaoEscolhida) {

			case 1:
				List<Filo> filos = visao.buscaTodosFilos();
				String filosTela = "";
				JOptionPane.showMessageDialog(null, filos);
				for (Filo i : filos) {
					filosTela = filosTela + i.getId() + i.getNome() + "\n";
				}

				JOptionPane.showMessageDialog(null, filosTela);
				break;

			case 2:
				String nomeFilo = JOptionPane.showInputDialog("Digite o nome do filo");
				f = new Filo(nomeFilo);
				visao.adiciona(f);
				break;

			case 3:
				f = new Filo("Filo vv");
				visao.altera(f);
				break;
				
			case 4:
				f = new Filo("Filo vv");
				visao.remove(f);
				break;
			}
		}
	}

}
