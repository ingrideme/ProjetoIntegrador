package com.reciclaveis.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

// Notação @Entity para criação de tabela. Entidade = Tabela
@Entity
@Table(name = "tb_usuarios")
public class Usuarios {
	
	//Data Notation para "avisar" pro entity especificações de cada atributo
	@Id
	//Notação para gerar automaticamente o id == AUTO_INCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 45)
	private String nome;
	
	@NotNull
	//@Email
	@Size(min = 3, max = 45)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

	@NotNull
	private boolean cooperativa;
	
	
	//Colocar outros atributos de contato(telefone e etc)
	
	@NotNull
	@Size(min = 3, max = 20)
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(boolean cooperativa) {
		this.cooperativa = cooperativa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
