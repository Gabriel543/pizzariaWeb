package br.com.senac.pizzariaweb.rascunho;



public class Aluno{
	private String nome;
	private double nota01;
	private double nota02;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, double nota01, double nota02) {
		this.nome  = nome;
		this.nota01 = nota01;
		this.nota02 = nota02;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNota01(double nota01) {
		this.nota01 = nota01;
	}
	
	public Double getNota01() {
		return nota01;
	}
	
	public void setNota02(double nota02) {
		this.nota02 = nota02;
	}
	
	public Double getNota02() {
		return nota02;
	}
	
	public Double getMedia() {
		return (nota01 + nota02) / 2;
	}
	
	
}
