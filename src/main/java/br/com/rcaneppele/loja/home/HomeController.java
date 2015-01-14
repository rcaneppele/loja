package br.com.rcaneppele.loja.home;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;

@Controller
public class HomeController {

	@Get({"/", "/home"})
	public void home() {
	}
	
}
