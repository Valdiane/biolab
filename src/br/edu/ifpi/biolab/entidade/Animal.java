package br.edu.ifpi.biolab.entidade;

public class Animal {

	private String nome;
	private Genero genero;
	private Reino reino;
	private Filo filo;
	private Especie especie;
	private Classe classe;
	private Ordem ordem;
	private Familia familia;

	public Animal(String nome, Genero genero, Reino reino, Filo filo, Especie especie, Classe classe, Ordem ordem,
			Familia familia) {
		this.nome = nome;
		this.genero = genero;
		this.reino = reino;
		this.filo = filo;
		this.especie = especie;
		this.classe = classe;
		this.ordem = ordem;
		this.familia = familia;

	}

	public String getNome() {
		return nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public Reino getReino() {
		return reino;
	}

	public Filo getFilo() {
		return filo;
	}

	public Especie getEspecie() {
		return especie;
	}

	public Classe getClasse() {
		return classe;
	}

	public Ordem getOrdem() {
		return ordem;
	}

	public Familia getFamilia() {
		return familia;
	}
	/* Reino -> Filo -> Classe -> Ordem -> Familia -> Genero -> Especie */

}
