package br.com.senac.pizzariaweb.controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.senac.pizzariaweb.modelo.Cliente;
import br.com.senac.pizzariaweb.util.SequenceID;

@WebServlet({ "/cliente/adicionar",  // post
			  "/cliente/remover",    // get
			  "/cliente/editar",     // get
			  "/cliente/atualizar",  // post
			  "/cliente/listar",     // get
			  "/cliente/localizar"   // get
})

public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	
    public ServletCliente() {
        super();
        
    }
    
    // responder requisição via GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/cliente/remover")) { // remover 
			remover(request,response);
		}else if(request.getServletPath().equals("/cliente/editar")) { // editar
			editar(request,response);
		}else if(request.getServletPath().equals("/cliente/listar")) { // listar
			listar(request,response);
		}else if(request.getServletPath().equals("/cliente/localizar")) { // localizar
			localizar(request,response);
		}else {
			response.getWriter().append("Página não localizada!!!: " + request.getMethod());
		}	
	}
	
	// responder requisição via POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getServletPath().equals("/cliente/adicionar")) { // adicionar
			adicionar(request,response);
		}else if(request.getServletPath().equals("/cliente/atualizar")) { // atualizar 
			atualizar(request,response);
		}else {
			response.getWriter().append("Página não localizada!!!: " + request.getMethod());
		}
	}
	
	// ctrl + shift + o  para  organizar seus imports
	protected void adicionar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* NO PHP quando queriamos resgatar um valor vindo do formulario 
		 * nós usavamos os comandos $_POST ou $_GET ou filter(INPUT_POST)...
		 * Agora no Java usaremos o método getParameter(), esse método é utilizado para ambos os casos,
		 * seja para dados enviados via post ou via get */
		
		String nome = request.getParameter("nome"); // atributo name do input html
		String email = request.getParameter("email"); // atributo name do input html
		String cpf = request.getParameter("cpf"); // atributo name do input html
		String senha = request.getParameter("senha"); // atributo name do input html
		
		Cliente c = new Cliente();
		
		c.setId(SequenceID.nextID());
		c.setNome(nome);
		c.setEmailCliente(email);
		c.setCpf(cpf);
		c.setSenhaCliente(senha);
		
		response.getWriter().append("Cliente cadastrado com sucesso!"
		+ "\nChamada ao método via: " + request.getMethod()
		+ "\nID: " + c.getId()
		+ "\nNome: " + c.getNome()
		+ "\nEmail: " + c.getEmailCliente()
		+ "\nCPF: " + c.getCpf()
		+ "\nSenha: " + c.getSenhaCliente()
		);
	}
	
	protected void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
	
	protected void localizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Chamada ao método via: " + request.getMethod());
	}
}
