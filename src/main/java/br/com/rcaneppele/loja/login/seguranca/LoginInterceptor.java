package br.com.rcaneppele.loja.login.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.rcaneppele.loja.login.LoginController;

@Intercepts
@RequestScoped
public class LoginInterceptor {

	@Inject
	private Sessao sessao;
	
	@Inject
	private Result result;
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		if (sessao.isIniciada()) {
			stack.next();
		} else {
			result.redirectTo(LoginController.class).login();
		}
	}
	
	@Accepts
	public boolean accepts(ControllerMethod method) {
	    return !method.getController().getType().isAnnotationPresent(AcessoPublico.class);
	}
	
}
