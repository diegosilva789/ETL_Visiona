<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar</title>
</head>
<body>
<jsp:include page="cabecalho.jsp"></jsp:include>
<form action="salvoCadastro.jsp" method="post">

<label>Nome:</label>
<input type="text" name="nome">

<label>Email:</label>
<input type="text" name="email">

<label>Senha:</label>
<input type="password" name="senha">

<input type="submit" value="Cadastrar">
</form>

</body>
</html>