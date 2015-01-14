<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty errors}">
	<div class="alert alert-danger">
		<c:forEach var="error" items="${errors}">
			${error.message} <br />
		</c:forEach>
	</div>
</c:if>
	
<c:if test="${not empty info}">
	<div class="alert alert-success">
		${info}
	</div>
</c:if>
