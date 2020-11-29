package br.com.pmanoelm.Loja.LojaDeArtigosGerais.service;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security.PasswordResetToken;


public interface UsuarioService {

	PasswordResetToken getPasswordResetToken(String token);

	void createPasswordResetTokenForUser(final Usuario user, final String  token);

}
