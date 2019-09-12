<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="br.edu.insper.Model.*" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
	<title>Projeto NODES</title>
  </head>
  <body>
	<h1>Nodes</h1>
	<hr />
	
	<c:set var="confirm" value='${requestScope.confirm}' />
	<c:if test="${confirm eq false}">
		<form action="index.jsp">
			Usuário e senha incorretos, tentre novamente <input type='submit' value='Voltar'>
		</form>
	</c:if>
	
 </body>
</html>