package br.edu.ifpi.biolab.entidade;

public class Genero {
	private int id;
	private String nome;
	private Familia familia;

	public Genero(String nome) {

		this.nome = nome;

	}

	public Genero(int id, String nome, Familia familia) {
		this.id = id;
		this.nome = nome;
		this.familia = familia;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
}
