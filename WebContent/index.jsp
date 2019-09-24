<%@page import="br.com.senac.pizzariaweb.modelo.Cliente"%>
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
	
	<%
		// é equivalente ao 'echo' ou 'document.wriet()'
		out.print("Olá Java Web");
	%>
	
	<%
		Cliente cli = new Cliente();
	
	%>

</body>
</html>