package br.com.rcaneppele.loja.usuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.rcaneppele.loja.util.Paginacao;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Inject
	private Paginacao paginacao;
	
	public void salva(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public void altera(Usuario usuario) {
		manager.merge(usuario);
	}

	public void remove(Usuario usuario) {
		usuario = manager.getReference(Usuario.class, usuario.getId());
		manager.remove(usuario);
	}
	
	public Usuario buscaPorLoginESenha(String login, String senha) {
		String jpql = "FROM Usuario WHERE login = :login AND senha = :senha";
		try {
			return manager.createQuery(jpql, Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Usuario> buscaPaginada(int pagina) {
		String query = "FROM Usuario ORDER BY login";
		return manager.createQuery(query, Usuario.class)
				.setFirstResult(paginacao.firstResult(pagina))
				.setMaxResults(paginacao.pageSize())
				.getResultList();
	}
	
	public Long count() {
		String query = "SELECT COUNT(*) FROM Usuario";
		try {
			return manager.createQuery(query, Long.class).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Usuario> buscaPorLoginLike(String login) {
		String query = "FROM Usuario WHERE login LIKE LOWER(:login) ORDER BY login";
		return manager.createQuery(query, Usuario.class)
				.setParameter("login", "%" +login.toLowerCase() +"%")
				.getResultList();
	}
	
}
