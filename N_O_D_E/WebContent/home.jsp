<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto NODES</title>
</head>
<body>
	<jsp:useBean id="dao" class="br.edu.insper.Model.DAO"/>
	<h1>Nodes</h1>
	<form action="index.jsp">
		<input type='submit' value='Log Off'>
	</form>
	<hr/>
	
	<c:set var="projetado" value='${requestScope.projetado}' />
	<c:choose>
		<c:when test="${projetado eq 1}">
	  		<p>Projeto já existente</p>
	  		<form action='home.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:when>
	  	<c:when test="${projetado eq 2}">
	  		<p>Projeto sem nome</p>
	  		<form action='home.jsp'>
	  			<input type='submit' value='Voltar' />
	  		</form>
	  	</c:when>
	  	<c:otherwise>
			<table border="1">
				<tr>
					<td><b>Anotações</b></td>
				</tr>
				<c:forEach var="project" items="${dao.projects}" varStatus="id">
					<tr bgcolor="#${id.count%2 == 0 ? '8FBC8F' : '66CDAA' }" >
						<td>
							${project.nome}
						</td>
						<td>
							<form action="DeleteProject" method="POST">
								<input type='hidden' value='${project.nome}' name='projectName'>
								<input type="submit" value="Deletar Anotação" />
							</form>
						</td>
						<td>
							<form action="ModifyProject" method="POST">
								<input type='hidden' value='${project.nome}' name='projectName'>
								<input type="text" value='' name="editCamp" />
								<input type="submit" value="Editar Anotação" />
							</form>	
						</td>
					 </tr>
				 </c:forEach>
			</table>
			
			<p></p>
			
			<form action="Home" method="POST">
				<p><b>Adicionar nota</b></p>
				<input type="text" name="nome_projeto" /><br />
				<p></p>
				<input type="submit" value="Criar Anotação" />
			</form>
	  	</c:otherwise>
	</c:choose>
</body>
</html>