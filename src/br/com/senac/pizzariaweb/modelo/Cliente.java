package br.com.senac.pizzariaweb.modelo;



public class Cliente {
	
	// atributo da classe cliente
	private Integer idCliente;
	private String nomeCliente;
	private String cpfCliente;
	private String emailCliente;
	private String senhaCliente;
	
	// construtor sem argumento
	public Cliente(){
		
	}
	
	// construtor com argumentos
	public Cliente(Integer idCliente,String nomeCliente,String cpfCliente, String emailCliente, String senhaCliente){
		// passagem de valores vindas do construtor para os atributos da classe
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.emailCliente = emailCliente;
		this.senhaCliente = senhaCliente;
		
		// o this serve para referenciar o membro da classe, ou seja, o atributo originado da classe.
	}
	
	// Métodos de encapsulamento
	
	// método get - retorna o valor do atributo
	
	public Integer getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int id) {
		idCliente = id;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	
	public void setNomeCliente(String nome) {
		nomeCliente = nome;
	}
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	
	public void setCpfCliente(String cpf) {
		cpfCliente = cpf;
	}
	
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
