package com.reciclaveis.api.model;

public class UsuariosLogin {
	
	private Long id;
	
	private String nomeFisOuJuri;
	
	private String fotoUser;
	
	private String cpfOuCnpj;
	
	private String senha;
	
	private String token;

	
	public String getFotoUser() {
		return fotoUser;
	}

	public void setFotoUser(String fotoUser) {
		this.fotoUser = fotoUser;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFisOuJuri() {
		return nomeFisOuJuri;
	}

	public void setNomeFisOuJuri(String nomeFisOuJuri) {
		this.nomeFisOuJuri = nomeFisOuJuri;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
