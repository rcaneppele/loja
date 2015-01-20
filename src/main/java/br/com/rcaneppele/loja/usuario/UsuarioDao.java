package br.com.rcaneppele.loja.usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;
	
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
	
}
