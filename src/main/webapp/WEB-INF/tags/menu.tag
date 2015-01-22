<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/" />">LOJA</a>
		</div>
			
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li>
					<a href="<c:url value="/vendas" />">Vendas</a>
				</li>
				<li>
					<a href="<c:url value="/estoque" />">Estoque</a>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
             			Cadastros <span class="caret"></span>
             		</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="<c:url value="/clientes" />">Clientes</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value="/produtos" />">Produtos</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value="/usuarios" />">Usuários</a>
						</li>
					</ul>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
             			Relatórios <span class="caret"></span>
             		</a>
					<ul class="dropdown-menu" role="menu">
						<li>
							<a href="<c:url value="/relatorios/vendas" />">Vendas</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value="/relatorios/financeiro" />">Financeiro</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value="/relatorios/top10clientes" />">Top 10 Clientes</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="<c:url value="/relatorios/top10produtos" />">Top 10 Produtos</a>
						</li>
					</ul>
				</li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<c:url value="/usuarios/meusdados" />">Logado como: ${sessao.usuario.login}</a>
				</li>
				<li>
					<a href="<c:url value="/logout" />">Sair</a>
				</li>
			</ul>
		</div>
	</div>
</nav>
