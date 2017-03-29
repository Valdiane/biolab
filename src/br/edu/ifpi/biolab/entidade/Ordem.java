package br.edu.ifpi.biolab.entidade;

public class Ordem {
	private int id;
	private String nome;
	private Classe classe;

	
	public Ordem( String nome) {
		this.nome = nome;
	}
	public Ordem(int id, String nome, Classe classe) {
		this.id = id;
		this.nome = nome;

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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

}
