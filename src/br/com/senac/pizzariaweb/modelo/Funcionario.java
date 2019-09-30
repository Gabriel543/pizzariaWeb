package br.com.senac.pizzariaweb.modelo;

public class Funcionario extends Pessoa{

	private double salario;
	private int matricula;
	
	// ctrl + espaço
	public Funcionario(){
		super();
	}
	
	public Funcionario(Integer id, String nome, String cpf,double salario,int matricula) {
		super(id,nome,cpf);
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
	
	public static void main(String[] args) {
		Funcionario fun = new Funcionario(1,"Gabriel","123123",1000,12);
		System.out.println(fun.getId());
		System.out.println(fun.getNome());
		System.out.println(fun.getCpf());
		System.out.println(fun.getSalario());
		System.out.println(fun.getMatricula());
	}
}
