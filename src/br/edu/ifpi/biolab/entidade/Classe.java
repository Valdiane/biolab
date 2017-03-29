package br.edu.ifpi.biolab.entidade;

public class Classe {
	private int id;
	private String nome;
	private Filo filo;

	public Classe(int id, String nome, Filo filo) {
		this.id = id;
		this.nome = nome;
		this.filo = filo;

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

	public Filo getFilo() {
		return filo;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}
}
