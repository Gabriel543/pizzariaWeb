package br.com.senac.pizzariaweb.modelo;

public class Funcionario {

	private Integer id;
	private String nome;
	private String cpf;
	private double salario;
	private int matricula;
	
	// ctrl + espaço
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	// (alt + shift + s) + r
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	// criar a classe pessoa
	// com os dados comuns das classes cliente e funcionario
	
	// refatorar as classes funcionario e cliente sem os dados comuns entre eles
	
	// usar o commando extend na assitura das classes cliente e funcionario para gerar a herança
	
	// fazer testes de criação dos objetos funcionario e cliente 
}
