<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!doctype html>
<html lang="en">
  <head>
    
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Pizzaria Web 402</title>
  </head>
  <body>
    <div class="container">
  		<table class="table table-striped">
  			<caption>Lista de Funcionarios</caption>
  			<thead>
  				<tr>
	  				<th>#</th>
	  				<th>Nome</th>
	  				<th>CPF</th>
	  				<th>Salario</th>
	  				<th>Matricula</th>
  				</tr>
  			</thead>
  			<tbody>
  				<!-- Tag responsavel por fazer repetições no HTML c:foreach -->
  				<c:forEach items="${listaFuncionarios}" var="funcionario">
	  				<tr>
		  				<td>${funcionario.id}</td>
		  				<td>${funcionario.nome}</td>
		  				<td>${funcionario.cpf}</td>
		  				<td>${funcionario.salario}</td>
		  				<td>${funcionario.matricula}</td>
		  				<td><a href="editar?id=${funcionario.id}">Editar</a></td>
		  				<td><a href="excluir?id=${funcionario.id}">Excluir</a></td>
	  				</tr>
	  			</c:forEach>
  			</tbody>
  		</table>
  	</div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>