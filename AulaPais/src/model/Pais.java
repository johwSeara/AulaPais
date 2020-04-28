package model;

public class Pais {

	private int id;
	private String nome;
	private long populacao;
	private double area;
	
	public Pais() {}
	
	public Pais(int id, String nome, long populacao, double area) {
		setId(id);
		setNome(nome);
		setPopulacao(populacao);
		setArea(area);
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

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "{Id: " + getId() + " Nome: " + getNome() + 
				" População: " + getPopulacao() + " Area: " + getArea() + "}";
	}
}
