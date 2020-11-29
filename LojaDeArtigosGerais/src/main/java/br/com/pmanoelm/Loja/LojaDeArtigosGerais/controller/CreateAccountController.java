package br.com.pmanoelm.Loja.LojaDeArtigosGerais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreateAccountController {
	@RequestMapping(value = "/CreateAccount", method = RequestMethod.GET)
	public String myaccount() {
		return "CreateAccount";
	}
}
