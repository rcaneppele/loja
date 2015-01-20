<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="loja" tagdir="/WEB-INF/tags" %>

<!DOCTYPE HTML>
<html>
<head>
	<loja:head/>
</head>

<body>
	<c:url value="/usuarios" var="url" />

	<loja:menu/>
	
	<div class="container">
		<loja:messages/>
			
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title text-center">CADASTRO DE USUÁRIO</h3>
			</div>
			
			<div class="panel-body">
				<form action="${url}" method="post" class="form-horizontal" data-toggle="validator">
					<c:if test="${not empty usuario.id}">
						<input type="hidden" name="_method" value="PUT" />
						<input type="hidden" name="usuario.id" value="${usuario.id}" />
					</c:if>
					
					<fieldset>
						<legend>Dados do Usuário</legend>
						<div class="form-group">
							<label for="login" class="col-sm-2 control-label">Login</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="login" name="usuario.login" value="${usuario.login}" required="required">
							</div>
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="senha" class="col-sm-2 control-label">Senha</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" id="senha" name="usuario.senha" required="required">
							</div>
							<div class="help-block with-errors"></div>
						</div>
					</fieldset>
					
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span> Gravar
					</button>
				</form>
			</div>
		</div>
	</div>
		
	<loja:scripts/>
</body>
</html>
