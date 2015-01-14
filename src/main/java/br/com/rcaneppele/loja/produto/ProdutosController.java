package br.com.rcaneppele.loja.produto;

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
public class ProdutosController {

	@Inject
	private Result result;
	
	@Inject
	private Validator validator;
	
	@Inject
	private ProdutoDao produtoDao;
	
	@Inject
	private ResourceBundle bundle;
	
	
	@Get("/produtos")
	public void produtos() {
		result.forwardTo(this).produtos(1);
	}
	
	@Get("/produtos/{pagina}")
	public void produtos(int pagina) {
		result.include("produtos", produtoDao.buscaPaginada(pagina));
		result.include("count", produtoDao.count());
	}
	
	@Post("/produtos/filtrar")
	public void filtra(@NotBlank(message = "{nome.obrigatorio}") String nome) {
		validator.onErrorRedirectTo(this).produtos();
		
		result.include("produtos", produtoDao.buscaPorNomeLike(nome));
		result.of(this).produtos();
	}
	
	@Get("/produtos/novo")
	public void novoProduto() {
	}

	@Post("/produtos")
	public void salva(@Valid Produto produto) {
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(produto);
		
		validaProdutoJaCadastrado(produto);

		produtoDao.salva(produto);
		result.include("info", bundle.getString("info.cadastro.sucesso"));
		result.redirectTo(this).produtos();
	}

	@Get("/produtos/editar/{id}")
	public void edita(Long id) {
		result.include("produto", produtoDao.buscaPorId(id));
		result.forwardTo(this).novoProduto();
	}

	@Put("/produtos")
	public void altera(@Valid Produto produto) {
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(produto);
		
		validaProdutoJaCadastrado(produto);

		produtoDao.altera(produto);
		result.include("info", bundle.getString("info.alteracao.sucesso"));
		result.redirectTo(this).produtos();
	}

	@Delete("/produtos")
	public void remove(Produto produto) {
		produtoDao.remove(produto);
		result.include("info", bundle.getString("info.remocao.sucesso"));
		result.redirectTo(this).produtos();
	}
	
	private void validaProdutoJaCadastrado(Produto produto) {
		Produto existente = produtoDao.buscaPorNome(produto.getNome());
		validator.addIf(existente != null && !existente.equals(produto), new I18nMessage("error", "produto.erro.cadastro.duplicado"));
		redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(produto);
	}

	private void redirecionaParaPaginaDeCadastroCasoOcorraErroDeValidacao(Produto produto) {
		if (produto.getId() == null) {
			validator.onErrorRedirectTo(this).novoProduto();
		} else {
			validator.onErrorRedirectTo(this).edita(produto.getId());
		}
	}
	
}
