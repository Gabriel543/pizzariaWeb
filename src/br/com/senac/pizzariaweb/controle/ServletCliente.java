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
import br.com.senac.pizzariaweb.persistencia.ClienteDAO;
import br.com.senac.pizzariaweb.util.SequenceID;

@WebServlet({ "/cliente/adicionar",
			  "/cliente/remover",
			  "/cliente/editar",
			  "/cliente/atualizar",
			  "/cliente/listar",
			  "/cliente/localizar"
			  })
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	private ClienteDAO dao;
    public ServletCliente() {
        super();
        dao = new ClienteDAO();
    }

    // via m�todo HTTP GET
    // HttpServletRequest - respons�vel por gerir todas as requisi��es enviadas para essa servlet
    // HttpServletResponse - respons�vel por gerir todas as respostas dessa servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/cliente/remover")) { // remover
			remover(request, response);
		} else if(request.getServletPath().equals("/cliente/editar")) { // editar
			editar(request, response);
		} else if(request.getServletPath().equals("/cliente/listar")) { // listar
			listar(request, response);
		} else if(request.getServletPath().equals("/cliente/localizar")) { // localizar
			localizar(request, response);
		} else {
			response.getWriter().append("P�gina n�o localizada!!! " + request.getMethod());
		}
	}
	
    // via m�todo HTTP POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/cliente/adicionar")) { // adicionar
			adicionar(request, response);
		} else if(request.getServletPath().equals("/cliente/atualizar")) { // remover
			atualizar(request, response);
		} else {
			response.getWriter().append("P�gina n�o localizada!!! " + request.getMethod());
		}
	}

	// ctrl + shift + o para organizar seus imports
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		/* No PHP.. quando queriamos resgatar um valor vindo do formulario
		 * n�s usavamos os comandos $_POST ou $_GET ou filter(INPUT_POST)..
		 * Agora no Java usaremos o m�todo getParameter(), esse m�todo � utilizado para ambos casos,
		 * seja para dados enviados via post ou via get
		 */
		
		// TUDO que vem da requisi��o, vem em formato String
		String nome = request.getParameter("txtNome"); // atributo name do input html
		String email = request.getParameter("txtEmail"); // atributo name do input html
		String cpf = request.getParameter("txtCPF").replace(".", "").replace("-", "");// atributo name do input html
		String senha = request.getParameter("txtSenha"); // atributo name do input html
		
		Cliente c = new Cliente();
		
//		c.setId(sequenceID.nextID());
		c.setNome(nome);
		c.setEmailCliente(email);
		c.setCpf(cpf);
		c.setSenhaCliente(senha);

		try {
			c.setId(dao.gravar(c));
			
			response.getWriter()
					.append("Cliente cadastrado com sucesso!\n")
					.append("Seus dados cadastrais foram:\n")
					.append("ID: " + c.getId())
					.append("\nNome: " + c.getNome())
					.append("\nEmail: " + c.getEmailCliente())
					.append("\nCPF: " + c.getCpf())
					.append("\nSenha: " + c.getSenhaCliente());
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Falha ao gravar no banco\n");
		}
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			dao.deletaCliente(id);
			response.sendRedirect("listar");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().append("Falha ao excluir no banco\n");
		}
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		try {
			request.setAttribute("cliente", dao.buscaPeloId(id));
			request.getRequestDispatcher("/formulario-edit-cliente.jsp").forward(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("pagina-erro.jsp?msg=eero_localizar");
		}
		
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("txtId"));
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCPF");
		String email = request.getParameter("txtEmail");
		
		try {
			dao.editarCliente(new Cliente(id,nome,cpf,email,null));
			listar(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("pagina-erro.jsp?msg=eero_localizar");
		}
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaClintes", dao.listar()); // os argumentos s�o (chave, valor);
			// dispacha a requisi��o para a p�gina lista-cliente.jsp encaminhando todas as requisi��es e respostas
			request.getRequestDispatcher("/lista-cliente.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("chamada ao m�todo localizar via " + request.getMethod());
	}
}
