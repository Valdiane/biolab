package br.edu.ifpi.biolab.entidade;

public class Familia {
	private int id;
	private String nome;
	private Ordem ordem;

	public Familia(String nome){
		this.nome = nome;	
	}
		
	
	public Familia(int id, String nome, Ordem ordem) {
		this.id = id;
		this.nome = nome;
		this.ordem = ordem;

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

	public Ordem getOrdem() {
		return ordem;
	}

	public void setOrdem(Ordem ordem) {
		this.ordem = ordem;
	}
}
