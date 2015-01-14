<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="<c:url value="/resources/js/lib/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/validator.min.js"/>"></script>
<script src="<c:url value="/resources/js/lib/jquery.price.min.js"/>"></script>

<script>
	(function($) {
		var inputs = document.querySelectorAll("input[required='required']"); 
		for (var i = 0; i < inputs.length; i++) {
			inputs[i].oninvalid = function() {
				this.setCustomValidity("");
				if (!this.validity.valid) {
					this.setCustomValidity("Campo obrigatório!");
				}
			};
		}
	})(jQuery);
</script>
