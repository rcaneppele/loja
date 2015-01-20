package br.com.rcaneppele.loja.usuario;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;

@Controller
public class UsuariosController {

	@Inject
	private Result result;
	
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
	
}
