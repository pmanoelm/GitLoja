package br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.security;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.pmanoelm.Loja.LojaDeArtigosGerais.Model.Usuario;

@Entity
public class PasswordResetToken {

	private static final int EXPIRRATION = 60 * 24;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String token;

	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private Usuario usuario;

	private Date expiryDate;

	public PasswordResetToken(final String token, final Usuario user) {
		super();
		this.token = token;
		this.usuario = user;
		this.expiryDate = calculateExpiryDate(EXPIRRATION);
	}

	private Date calculateExpiryDate(final int expiryTimeMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeMinutes);
		return new Date(cal.getTime().getTime());

	}

	public void updateToken(final String token) {
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRRATION);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getExpriryDate() {
		return expiryDate;
	}

	public void setExpriryDate(Date expriryDate) {
		this.expiryDate = expriryDate;
	}

	public static int getExpirration() {
		return EXPIRRATION;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUser() {
		return usuario;
	}

	public void setUser(Usuario user) {
		this.usuario = user;
	}

	@Override
	public String toString() {
		return "PasswordResetToken [id=" + id + ", token=" + token + ", user=" + usuario + ", expriryDate=" + expiryDate
				+ "]";
	}

}
