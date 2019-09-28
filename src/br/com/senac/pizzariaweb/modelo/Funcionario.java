package br.com.senac.pizzariaweb.modelo;

public class Funcionario extends Pessoa{

	private double salario;
	private int matricula;
	
	// ctrl + espaço
	public Funcionario() {
	}
	
	public Funcionario(double salario,int matricula) {
		
		this.salario = salario;
		this.matricula = matricula;
	}
	
	// (alt + shift + s) + r

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
