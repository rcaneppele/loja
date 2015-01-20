package br.com.rcaneppele.loja.util;

public class Paginacao {

	private static final int PAGE_SIZE = 10;
	
	public int pageSize() {
		return PAGE_SIZE;
	}

	public int firstResult(int pagina) {
		return (pagina - 1) * PAGE_SIZE;
	}
	
}
