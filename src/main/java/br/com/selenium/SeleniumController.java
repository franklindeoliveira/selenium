package br.com.selenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SeleniumController {
	
	@RequestMapping("/pagina")
	public String pagina(String pagina) {
		return pagina;
	}

}