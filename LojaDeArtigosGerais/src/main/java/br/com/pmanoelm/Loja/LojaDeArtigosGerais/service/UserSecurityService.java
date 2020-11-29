package br.com.pmanoelm.Loja.LojaDeArtigosGerais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;
import br.com.pmanoelm.Loja.LojaDeArtigosGerais.repository.UsuarioRepository;

@Service
public class UserSecurityService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository usuarioReposiroty;
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioReposiroty.findByUsername(username);
		
		if (null ==user) {
			throw new UsernameNotFoundException("Usuario não encontrado");
		}
		
		return user;
	}
	
}
