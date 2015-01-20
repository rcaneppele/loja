package br.com.rcaneppele.loja.usuario;

import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuariosController {

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	private ResourceBundle bundle;
	
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
	
	@Get("/usuarios/novo")
	public void novoUsuario() {
	}

	@Post("/usuarios")
	public void salva(@Valid Usuario usuario) {
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(usuario);
		
		validaUsuarioJaCadastrado(usuario);

		usuarioDao.salva(usuario);
		result.include("info", bundle.getString("info.cadastro.sucesso"));
		result.redirectTo(this).usuarios();
	}
	
	@Get("/usuarios/editar/{id}")
	public void edita(Long id) {
		result.include("usuario", usuarioDao.buscaPorId(id));
		result.forwardTo(this).novoUsuario();
	}
	
	@Put("/usuario")
	public void altera(@Valid Usuario usuario) {
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(usuario);
		
		validaUsuarioJaCadastrado(usuario);

		usuarioDao.altera(usuario);
		result.include("info", bundle.getString("info.alteracao.sucesso"));
		result.redirectTo(this).usuarios();
	}
	
	@Delete("/usuarios")
	public void remove(Usuario usuario) {
		usuarioDao.remove(usuario);
		result.include("info", bundle.getString("info.remocao.sucesso"));
		result.redirectTo(this).usuarios();
	}
	
	private void validaUsuarioJaCadastrado(Usuario usuario) {
		Usuario existente = usuarioDao.buscaPorLogin(usuario.getLogin());
		validator.addIf(existente != null && !existente.equals(usuario), new I18nMessage("error", "usuario.erro.cadastro.duplicado"));
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(usuario);
	}

	private void redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(Usuario usuario) {
		if (usuario.getId() == null) {
			validator.onErrorRedirectTo(this).novoUsuario();
		} else {
			validator.onErrorRedirectTo(this).edita(usuario.getId());
		}
	}
	
}
