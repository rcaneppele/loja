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
	<c:url value="/usuarios/meusdados" var="url" />

	<loja:menu/>
	
	<div class="container">
		<loja:messages/>
			
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title text-center">ATUALIZAR MEUS DADOS</h3>
			</div>
			
			<div class="panel-body">
				<form action="${url}" method="post" class="form-horizontal" data-toggle="validator">
					<fieldset>
						<div class="form-group">
							<label for="login" class="col-sm-2 control-label">Login</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="login" name="login" value="${sessao.usuario.login}">
							</div>
						</div>
						
						<div class="form-group">
							<label for="senhaAtual" class="col-sm-2 control-label">Senha atual</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" id="senhaAtual" name="senhaAtual" required="required">
							</div>
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="novaSenha" class="col-sm-2 control-label">Nova senha</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" id="novaSenha" name="novaSenha" required="required">
							</div>
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="confirmacaoNovaSenha" class="col-sm-2 control-label">Confirmação nova senha</label>
							<div class="col-sm-4">
								<input type="password" class="form-control" id="confirmacaoNovaSenha" name="confirmacaoNovaSenha" 
									required="required" data-match="#novaSenha" data-match-error="Nova senha e confirmação nova senha devem ser iguais!">
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
