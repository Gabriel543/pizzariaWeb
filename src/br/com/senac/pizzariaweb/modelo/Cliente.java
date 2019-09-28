package br.com.senac.pizzariaweb.modelo;



public class Cliente extends Pessoa{
	
	// atributo da classe cliente

	private String emailCliente;
	private String senhaCliente;
	
	// construtor sem argumento
	public Cliente(){
		
	}
	
	// construtor com argumentos
	public Cliente(String emailCliente, String senhaCliente){
		// passagem de valores vindas do construtor para os atributos da classe
		this.emailCliente = emailCliente;
		this.senhaCliente = senhaCliente;
		
		// o this serve para referenciar o membro da classe, ou seja, o atributo originado da classe.
	}
	
	// Métodos de encapsulamento
	
	// método get - retorna o valor do atributo
	
	public String getEmailCliente() {
		return emailCliente;
	}
	
	public void setEmailCliente(String email) {
		emailCliente = email;
	}
	
	public String getSenhaCliente() {
		return senhaCliente;
	}
	
	public void setSenhaCliente(String senha) {
		senhaCliente = senha;
	}
}
