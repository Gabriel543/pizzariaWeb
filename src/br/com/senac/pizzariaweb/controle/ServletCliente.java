package br.com.senac.pizzariaweb.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
