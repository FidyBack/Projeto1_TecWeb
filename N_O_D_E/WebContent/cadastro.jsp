<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<title>JPS Cadastro</title>
  </head>
  <body>
  
  	<c:set var="cadastro" value='${requestScope.cadastro}' />
  	
  	<c:choose>
	  	<c:when test="${cadastro eq 1}">
	  		<p>Nome de usuário já existente</p>
	  		<form action='index.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:when>
	  	<c:when test="${cadastro eq 2}">
	  		<p>Algo está faltando, tente novamente</p>
	  		<form action='index.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:when>
	  	<c:when test="${cadastro eq 3}">
	  		<p>Senhas não correspondem, tente novamente</p>
	  		<form action='index.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:when>
	  	<c:otherwise>
			<p>Cadastro feito com sucesso!!!</p>
	  		<form action='index.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:otherwise>
  	</c:choose>
  </body>
</html>