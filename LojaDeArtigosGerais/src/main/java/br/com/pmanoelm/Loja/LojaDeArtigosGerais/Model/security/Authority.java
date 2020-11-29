package br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String authority;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}

	public Authority(String authority) {
		
		this.authority=authority;
	}

}
