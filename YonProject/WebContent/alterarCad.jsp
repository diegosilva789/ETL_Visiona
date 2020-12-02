<%@page import="beans.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<%
	Usuario usu = (Usuario)request.getAttribute("usuario");
%>
<form action="UsuarioControllador" method="post">
	<input type="hidden" name="acao" value="salvar">

	<label>ID:</label>
	<input size="5" type="text" name="id" value="<%=usu.getId()%>">

	<label>Nome:</label>
	<input type="text" name="nome" value="<%=usu.getNome()%>">
	
	<label>Email:</label>
	<input type="text" name="email" value="<%=usu.getEmail()%>">
	
	<label>Senha:</label>
	<input type="password" name="senha" value="<%=usu.getSenha()%>">
	
	<input type="submit" value="Salvar">
</form>
</body>
</html>