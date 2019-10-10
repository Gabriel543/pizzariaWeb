package br.com.senac.pizzariaweb.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.pizzariaweb.modelo.Funcionario;
import br.com.senac.pizzariaweb.util.SequenceID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/funcionario/adicionar", "/funcionario/editar", "/funcionario/excluir", "/funcionario/listar", "/funcionario/atualizar", "/funcionario/localizar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Funcionario> funcionarios;
	private SequenceID sequenceID;   

    public ServletFuncionario() {
        super();
        funcionarios = new ArrayList<Funcionario>();
		sequenceID = new SequenceID();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/funcionario/excluir")) { // remover
			excluir(request, response);
		} else if(request.getServletPath().equals("/funcionario/editar")) { // editar
			editar(request, response);
		} else if(request.getServletPath().equals("/funcionario/listar")) { // listar
			listar(request, response);
		} else if(request.getServletPath().equals("/funcionario/localizar")) { // localizar
			localizar(request, response);
		} else {
			response.getWriter().append("Página não localizada!!! " + request.getMethod());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/funcionario/adicionar")) { // adicionar
			adicionar(request,response);
		}else if(request.getServletPath().equals("/funcionario/atualizar")) { // atualizar 
			atualizar(request,response);
		}else {
			response.getWriter().append("Página não localizada!!!: " + request.getMethod());
		}
	}
	
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		int matricula = Integer.valueOf(request.getParameter("matricula"));
		String cpf = request.getParameter("cpf");
		double salario = Double.valueOf(request.getParameter("salario").replace(".", "").replace(",", ""));
		
		Funcionario f = new Funcionario(sequenceID.nextID(), nome, cpf, salario, matricula);
		
		funcionarios.add(f);
		
		for (Funcionario fun : funcionarios) {
			response.getWriter().append("Funcionario cadastrado com sucesso!<br>"
				+ "Seus dados cadastrais foram:<br>"
				+ "ID: " + fun.getId()
				+ "<br>Nome: " + fun.getNome()
				+ "<br>Matricula: " + fun.getMatricula()
				+ "<br>CPF: " + fun.getCpf()
				+ "<br>Salario: " + fun.getSalario() + "<br><br>");
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for (Funcionario fun : funcionarios) {
			response.getWriter().append("Funcionario cadastrado com sucesso!<br>"
				+ "\nSeus dados cadastrais foram:<br>"
				+ "\nID: " + fun.getId()
				+ "\n<br>Nome: " + fun.getNome()
				+ "\n<br>Matricula: " + fun.getMatricula()
				+ "\n<br>CPF: " + fun.getCpf()
				+ "\n<br>Salario: " + fun.getSalario() + "\n\n<br><br>");
		}
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cont = 0;
		for (Funcionario fun : funcionarios) {
			if(Integer.parseInt(request.getParameter("id")) == fun.getId()) {
				funcionarios.remove(cont);
				response.getWriter().append("Funcionario excluído.");
				break;
			}
			cont++;
		}		
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}

}
