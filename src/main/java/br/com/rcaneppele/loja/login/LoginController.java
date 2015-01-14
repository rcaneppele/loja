package br.com.rcaneppele.loja.login;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.rcaneppele.loja.home.HomeController;
import br.com.rcaneppele.loja.login.seguranca.AcessoPublico;
import br.com.rcaneppele.loja.login.seguranca.Criptografia;
import br.com.rcaneppele.loja.login.seguranca.Sessao;

@Controller
@AcessoPublico
public class LoginController {
	
	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	private UsuarioDao dao;
	
	@Inject
	private Criptografia criptografia;
	
	@Inject
	private Sessao sessao;
	
	@Inject
	private HttpSession session;

	@Get("/login")
	public void login() {
	}
	
	@Post("/login")
	public void autentica(String login, String senha) {
		String senhaCriptografada = criptografia.criptografa(senha, login);
		Usuario usuario = dao.buscaPorLoginESenha(login, senhaCriptografada);
		validaUsuarioCadastrado(usuario);
		
		sessao.inicia(usuario);
		result.redirectTo(HomeController.class).home();
	}
	
	@Get("/logout")
	public void logout() {
		session.invalidate();
		result.redirectTo(this).login();
	}

	private void validaUsuarioCadastrado(Usuario usuario) {
		validator.addIf(usuario == null, new I18nMessage("error", "usuario.invalido"));
		validator.onErrorRedirectTo(this).login();
	}
	
}
