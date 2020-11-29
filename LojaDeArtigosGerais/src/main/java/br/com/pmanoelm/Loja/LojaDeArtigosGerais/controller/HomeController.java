package br.com.pmanoelm.Loja.LojaDeArtigosGerais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value ="/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin",true);
		return "MyAccount";
		
	}
	@RequestMapping(value ="/CreateAccount")
	public String create(Model model) {
		model.addAttribute("classActiveCreate",true);
		return "CreateAccount";
		
	}

}
