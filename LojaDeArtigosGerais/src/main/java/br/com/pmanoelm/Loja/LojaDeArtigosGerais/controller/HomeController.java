package br.com.pmanoelm.Loja.LojaDeArtigosGerais.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security.PasswordResetToken;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.service.UserSecurityService;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UserSecurityService userSecurityService;

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "MyAccount";

	}

	@RequestMapping(value = "/CreateAccount")
	public String create(Locale locale, @RequestParam("token") String token, Model model) {
		PasswordResetToken passtoken = usuarioService.getPasswordResetToken(token);

		if (passtoken == null) {
			String message = "invalid Token";
			model.addAttribute("message", message);
			return "redirect:/badRquqest";
		}
		
		Usuario user = passtoken.getUser();		
		String username = user.getUsername();
		
		UserDetails userDetails = userSecurityService.loadUserByUsername(username);
		
		Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(),
				userDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		model.addAttribute("classActiveCreate", true);
		return "CreateAccount";

	}
}
