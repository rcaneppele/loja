<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="url" required="true" %>
<%@ attribute name="count" required="true" %>

<c:set var="linhas" value="10" />
<c:set var="paginas" value="${count / linhas}" />
<c:set var="paginasRoundedUp" value="${paginas + (1 - (paginas % 1)) % 1}" />

<c:if test="${paginasRoundedUp gt 1}">
	<nav class="text-center">
		<ul class="pagination">
			<c:forEach begin="1" end="${paginasRoundedUp}" varStatus="index">
				<li>
					<a href="${url}/${index.count}">${index.count}</a>
				</li>
			</c:forEach>
		</ul>
	</nav>
</c:if>
