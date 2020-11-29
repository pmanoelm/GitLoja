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
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
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
	
	
	
	

}
