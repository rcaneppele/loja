package br.com.rcaneppele.loja.login.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.rcaneppele.loja.login.Usuario;

@SessionScoped
@Named
public class Sessao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	
	public void inicia(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isIniciada() {
		return usuario != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
