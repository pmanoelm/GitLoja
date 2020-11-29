package br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;

@Entity
@Table(name = "usar_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private Usuario user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	
	

	public UserRole(Usuario user, Role role) {
		this.user = user;
		this.role = role;
	}



	public Long getUserRoleId() {
		return userRoleId;
	}



	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}



	public Usuario getUser() {
		return user;
	}



	public void setUser(Usuario user) {
		this.user = user;
	}



	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	

}
