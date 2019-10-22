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

import br.com.senac.pizzariaweb.modelo.Cliente;
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
		String cpf = request.getParameter("txtCPF").replace(".", "").replace("-", "");
		String matricula = request.getParameter("txtMatricula");
		
		Funcionario f = new Funcionario();
		
		f.setNome(nome);
		f.setSalario(Double.parseDouble(salario));
		f.setCpf(cpf);
		f.setMatricula(Integer.parseInt(matricula));
		
		try {
			f.setId(dao.gravar(f));
			response.getWriter().append("Funcionario cadastrado com sucesso!"
					+ "\nSeus dados cadastrais foram:"
					+ "\nID: " + f.getId()
					+ "\nNome: " + f.getNome()
					+ "\nMatricula: " + f.getMatricula()
					+ "\nCPF: " + f.getCpf()
					+ "\nSalario: " + f.getSalario() + "\n\n");
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Falha ao gravar no banco\n");
		}
	}

	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaFuncionarios", dao.listar());
			request.getRequestDispatcher("/lista-funcionario.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.deletaFuncionario(id);
			response.sendRedirect("listar");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Falha ao excluir no banco\n");
		}
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			request.setAttribute("funcionario", dao.buscaPeloId(id));
			request.getRequestDispatcher("/formulario-edit-funcionario.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("pagina-erro.jsp?msg=eero_localizar");
		}
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("txtId"));
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCPF");
		double salario = Double.valueOf(request.getParameter("txtSalario").replace(",", "").replace("", "."));
		try {
			dao.editarFuncionario(new Funcionario(id, nome, cpf,salario,0));
			listar(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("pagina-erro.jsp?msg=eero_localizar");
		}
	}
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Chamada ao método via: " + request.getMethod());
		}
	
}
