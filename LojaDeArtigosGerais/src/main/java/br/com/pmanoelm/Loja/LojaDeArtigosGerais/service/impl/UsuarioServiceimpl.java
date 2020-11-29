package br.com.pmanoelm.Loja.LojaDeArtigosGerais.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security.PasswordResetToken;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.repository.PasswordResetTokenRepository;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.service.UsuarioService;

@Service
public class UsuarioServiceimpl implements UsuarioService {
	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
		
	@Override
	public PasswordResetToken getPasswordResetToken(String token) {
		return passwordResetTokenRepository.findByToken(token);

	}

	@Override
	public void createPasswordResetTokenForUser(Usuario user, String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
		passwordResetTokenRepository.save(myToken);
	}

}
