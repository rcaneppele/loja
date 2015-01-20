package br.com.rcaneppele.loja.usuario;

import javax.inject.Inject;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuariosController {

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Get("/usuarios")
	public void usuarios() {
		result.forwardTo(this).usuarios(1);
	}
	
	@Get("/usuarios/{pagina}")
	public void usuarios(int pagina) {
		result.include("usuarios", usuarioDao.buscaPaginada(pagina));
		result.include("count", usuarioDao.count());
	}
	
	@Post("/usuarios/filtrar")
	public void filtra(@NotBlank(message = "{login.obrigatorio}") String login) {
		validator.onErrorRedirectTo(this).usuarios();
		
		result.include("usuarios", usuarioDao.buscaPorLoginLike(login));
		result.of(this).usuarios();
	}
	
}
