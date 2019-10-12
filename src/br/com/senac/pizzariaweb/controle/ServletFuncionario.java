package br.com.senac.pizzariaweb.controle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.pizzariaweb.modelo.Funcionario;
import br.com.senac.pizzariaweb.persistencia.FuncionarioDAO;
import br.com.senac.pizzariaweb.util.SequenceID;

@WebServlet({ "/funcionario/adicionar", "/funcionario/editar", "/funcionario/excluir", "/funcionario/listar", "/funcionario/atualizar", "/funcionario/localizar" })
public class ServletFuncionario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Funcionario> funcionarios;
	private SequenceID sequenceID;
	private FuncionarioDAO dao;

    public ServletFuncionario() {
        super();
        funcionarios = new ArrayList<Funcionario>();
		sequenceID = new SequenceID();
		dao = new FuncionarioDAO();
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
		
		String nome = request.getParameter("txtNome"); 
		String salario = request.getParameter("txtSalario"); 
		String cpf = request.getParameter("txtCPF"); 
		String matricula = request.getParameter("txtMatricula");
		
		Funcionario f = new Funcionario();
		
		f.setNome(nome);
		f.setSalario(Double.parseDouble(salario));
		f.setCpf(cpf);
		f.setMatricula(Integer.parseInt(matricula));
		
		try {
			dao.gravar(f);
			response.getWriter().append("Funcionario cadastrado com sucesso!<br>"
					+ "\nSeus dados cadastrais foram:<br>"
					+ "\nID: " + f.getId()
					+ "\n<br>Nome: " + f.getNome()
					+ "\n<br>Matricula: " + f.getMatricula()
					+ "\n<br>CPF: " + f.getCpf()
					+ "\n<br>Salario: " + f.getSalario() + "\n\n<br><br>");
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Falha ao gravar no banco\n");
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
