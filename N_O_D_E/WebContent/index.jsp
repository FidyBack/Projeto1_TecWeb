<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="UTF-8"%>
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
	
	<form action="Login" method="POST">
		<h2>Log In</h2>
		Nome: <input type="text" name="nome_user" /><br />
		Senha: <input type="password" name="senha_user" /><br />
		<input type="submit" value="Log In" />
	</form>
	
	<form action="Cadastro" method="POST">
		<h2>Cadastre-se</h2>
		Nome: <input type="text" name="nome_cad" /><br />
		Senha: <input type="password" name="senha_cad" /><br />
		Confirme a Senha: <input type="password" name="senha_cadconf" /><br />
		<input type="submit" value="Cadastrar" />
	</form>
	
  </body>
</html>