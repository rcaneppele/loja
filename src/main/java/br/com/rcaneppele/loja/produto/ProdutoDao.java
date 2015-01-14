package br.com.rcaneppele.loja.produto;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.rcaneppele.loja.util.Paginacao;

@Stateless
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;
	
	@Inject
	private Paginacao paginacao;

	public void salva(Produto produto) {
		em.persist(produto);
	}
	
	public void altera(Produto produto) {
		em.merge(produto);
	}

	public void remove(Produto produto) {
		produto = em.getReference(Produto.class, produto.getId());
		em.remove(produto);
	}
	
	public List<Produto> buscaPaginada(int pagina) {
		String query = "FROM Produto ORDER BY nome";
		return em.createQuery(query, Produto.class)
				.setFirstResult((pagina - 1) * paginacao.getPageSize())
				.setMaxResults(paginacao.getPageSize())
				.getResultList();
	}
	
	public Long count() {
		String query = "SELECT COUNT(*) FROM Produto";
		try {
			return em.createQuery(query, Long.class).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Produto buscaPorId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public Produto buscaPorNome(String nome) {
		String query = "FROM Produto WHERE nome = :nome";
		try {
			return em.createQuery(query, Produto.class).setParameter("nome", nome).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Produto> buscaPorNomeLike(String nome) {
		String query = "FROM Produto WHERE nome LIKE LOWER(:nome) ORDER BY nome";
		return em.createQuery(query, Produto.class)
				.setParameter("nome", "%" +nome.toLowerCase() +"%")
				.getResultList();
	}
	
}
