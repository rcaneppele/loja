<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="loja" tagdir="/WEB-INF/tags" %>

<!DOCTYPE HTML>
<html>
<head>
	<loja:head/>
</head>

<body>
	<loja:messages/>
	
	<div class="container">
		<form class="form-signin" action="<c:url value="/login"/>" method="post">
			<h2 class="form-signin-heading">Login</h2>
			
			<input type="text" name="login" class="form-control" placeholder="Usuário" required="required" autofocus="autofocus" />
			<input type="password" name="senha" class="form-control" placeholder="Senha" required="required" />
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
		</form>
	</div>
</body>
</html>
