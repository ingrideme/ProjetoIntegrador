package com.reciclaveis.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

// Notação @Entity para criação de tabela. Entidade = Tabela
@Entity
@Table(name = "tb_usuarios")
public class Usuarios {

	// Data Notation para "avisar" pro entity especificações de cada atributo
	@Id
	// Notação para gerar automaticamente o id == AUTO_INCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 3, max = 45)
	private String nomeFisOuJuri;

	@NotNull
	// @Email
	@Size(min = 3, max = 45)
	private String email;

	@NotNull
	@Size(min = 12, max = 14) // desconsiderando pontos e traços / duvida front.
	private String cpfOuCnpj;

	//@Temporal(TemporalType.TIMESTAMP)
	//private Date data = new java.sql.Date(System.currentTimeMillis());

	private String cooperativa;

	private String localidade;
	

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getCooperativa() {
		return cooperativa;
	}
	
	@NotNull
	@Size(min = 3)
	private String senha;
	
	@OneToMany(mappedBy ="usuarios",cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarios")
	private List<Produtos> produtos;
	

	/*@OneToMany(mappedBy = "usuarioCriador", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Produtos> meusProdutosCriados = new ArrayList<>();
*/
	/*
	@ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinTable(name = "vendas", joinColumns = @JoinColumn(name = "comprador_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private List<Produtos> meusProdutosComprados = new ArrayList<>();
*/
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
*/
	public String isCooperativa() {
		return cooperativa;
	}

	public void setCooperativa(String cooperativa) {
		this.cooperativa = cooperativa;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	
}
