package br.edu.ifpi.biolab.entidade;

public class Filo {
	private int id;
	private String nome;
	private Reino reino;
	
	public Filo(String nome) {
		this.nome = nome;
	}
	
	public Filo(int id, String nome, Reino reino) {
		this.id = id;
		this.nome = nome;
		this.reino = reino;

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

	public Reino getReino() {
		return reino;
	}

	public void setReino(Reino reino) {
		this.reino = reino;
	}
}