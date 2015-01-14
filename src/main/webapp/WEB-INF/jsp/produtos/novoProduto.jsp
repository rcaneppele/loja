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
	<c:url value="/produtos" var="url" />

	<loja:menu/>
	
	<div class="container">
		<loja:messages/>
			
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title text-center">CADASTRO DE PRODUTO</h3>
			</div>
			
			<div class="panel-body">
				<form action="${url}" method="post" class="form-horizontal" data-toggle="validator">
					<c:if test="${not empty produto.id}">
						<input type="hidden" name="_method" value="PUT" />
						<input type="hidden" name="produto.id" value="${produto.id}" />
					</c:if>
					
					<fieldset>
						<legend>Dados do Produto</legend>
						<div class="form-group">
							<label for="nome" class="col-sm-2 control-label">Nome</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="nome" name="produto.nome" value="${produto.nome}" required="required">
							</div>
							<div class="help-block with-errors"></div>
						</div>
						
						<div class="form-group">
							<label for="descricao" class="col-sm-2 control-label">Descricao</label>
							<div class="col-sm-4">
								<textarea id="descricao" name="produto.descricao" rows="3" class="form-control">${produto.descricao}</textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label for="preco" class="col-sm-2 control-label">Preço</label>
							<div class="col-sm-4">
								<input type="text" class="form-control dinheiro" id="preco" name="produto.preco" value="${produto.preco}" required="required">
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
