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
				<h3 class="panel-title text-center">PRODUTOS CADASTRADOS</h3>
			</div>
			
			<div class="panel-body">
				<div class="row">
					<div class="col-md-1">
						<a href="${url}/novo" class="btn btn-primary">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Novo
						</a>
					</div>
					
					<div class="col-md-3 col-md-offset-8">
						<form action="${url}/filtrar" method="post" data-toggle="validator">
							<div class="input-group form-group">
								<input type="text" name="nome" class="form-control" placeholder="Nome..." required="required" />
								<span class="input-group-btn">
									<button type="submit" class="btn btn-default">Filtrar</button>
								</span>
							</div>
						</form>
					</div>
				</div>
				
				<br/>
				
				<div class="table-responsive">
					<table class="table table-striped table-hover table-filter">
						<thead>
							<tr>
								<th>ID</th>
								<th>NOME</th>
								<th>PREÇO</th>
								<th>AÇÕES</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${produtos}" var="produto">
								<tr>
									<td>${produto.id}</td>
									<td>${produto.nome}</td>
									<td>
										<fmt:formatNumber type="currency" currencySymbol="R$" value="${produto.preco}" />
									</td>
									<td>
										<a href="${url}/editar/${produto.id}" class="btn btn-info">
											<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Editar
										</a>
										
										<a href="#" class="btn btn-danger" onclick="confirmaExclusao('form-excluir-${produto.id}');">
											<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Excluir
										</a>
										<form action="${url}" method="post" id="form-excluir-${produto.id}" class="hidden">
											<input type="hidden" name="_method" value="DELETE" />
											<input type="hidden" name="produto.id" value="${produto.id}" />
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
				<c:if test="${not empty count}">
					<loja:paginacao url="${url}" count="${count}"/>
				</c:if>
			</div>
		</div>
	</div>
		
	<loja:scripts/>
</body>
</html>
