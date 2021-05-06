package com.reciclaveis.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

//Notação @Entity para criação de tabela. Entidade = Tabela
@Entity
@Table(name = "tb_tipos")
public class Tipo
{
	//Data Notation para "avisar" pro entity especificações de cada atributo
	@Id
	//Notação para gerar automaticamente o id == AUTO_INCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	
	/*MappedBy: falar quem é o dono da relação  
	 Cascade: caso você apague uma tabela essa
		ela apaga também a que está relacionada com ela
	*/
	@OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL) 
	@JsonIgnoreProperties("tipo") //ignorar atributos de uma classe na hora que for ler ela
	private List<Produtos> produto;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String nomeTipo;
	
	@NotNull
	@Size(min = 3, max = 300)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date data = new java.sql.Date(System.currentTimeMillis());

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}
