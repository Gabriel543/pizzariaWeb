package br.com.senac.pizzariaweb.modelo;


// o "start" da herança é dado pela palavra "extends"
public class Cliente extends Pessoa{
	
	// atributo da classe cliente

	private String emailCliente;
	private String senhaCliente;
	
	// construtor sem argumento
	public Cliente(){
		super(); // chama o construtor sem argumentos da classe pai por padrão
	}
	
	// construtor com argumentos
	public Cliente(Integer id, String nome, String cpf,String emailCliente, String senhaCliente){
		// passagem de valores vindas do construtor para os atributos da classe
		// super -  referencia a superclasse (classe pai)
		super(id,nome,cpf);
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
	public static void main(String[] args) {
		Cliente cli = new Cliente(1,"Gabriel","123123","gabriel@gmail","1234");
		System.out.println(cli.getId());
		System.out.println(cli.getNome());
		System.out.println(cli.getCpf());
		System.out.println(cli.getEmailCliente());
		System.out.println(cli.getSenhaCliente());
	}
}
