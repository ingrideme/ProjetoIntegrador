package com.reciclaveis.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;


//Notação @Entity para criação de tabela. Entidade = Tabela
@Entity
@Table(name = "tb_produtos")
public class Produtos {


	//Data Notation para "avisar" pro entity especificações de cada atributo
	@Id
	//Notação para gerar automaticamente o id == AUTO_INCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, max = 45)
	private String nomeProduto;
	@NotNull
	private float peso;

	@Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Tipo tipo;
	
	private int quantidade;
	
	private int preco;
	
	private String fotoProduto;
			
	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public String getFotoProduto() {
		return fotoProduto;
	}


	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}


	@ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	@JoinColumn(name = "criador")
	private Usuarios usuarioCriador;
	
	@ManyToMany(mappedBy = "meusProdutosComprados", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Usuarios> compradores = new ArrayList<>();
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}
	

	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}


	public Usuarios getUsuarioCriador() {
		return usuarioCriador;
	}


	public void setUsuarioCriador(Usuarios usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}


	public List<Usuarios> getCompradores() {
		return compradores;
	}


	public void setCompradores(List<Usuarios> compradores) {
		this.compradores = compradores;
	}

	
	
		
	
}
