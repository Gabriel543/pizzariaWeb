<%@page import="br.com.senac.pizzariaweb.modelo.Cliente"%>
<%@page import="br.com.senac.pizzariaweb.modelo.Funcionario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pizzaria Web 402</title>
</head>
<body>
	<!-- Os blocos de código incorporados na página, que nem faziamos no PHP chama-se SCRIPTLET --> 
	<ul>
		<li>Clientes
			<ul>
				<li><a href="formulario-cliente.jsp">Formulário de Cadastro de Clientes</a></li>
				<li><a href="cliente/listar">Lista de Cadastro Cliente</a></li>
			</ul>
		</li>
		<li>Funcionários
			<ul>
				<li><a href="formulario-funcionario.jsp">Formulário de Cadastro de Funcionários</a></li>
				<li><a href="funcionario/listar">Lista de Cadastro Funcionários</a></li>
			</ul>
		</li>
	</ul>
	
	
</body>
</html>