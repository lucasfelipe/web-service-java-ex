package com.facnet.ws.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the produtos database table.
 * 
 */
@XmlRootElement(name = "produto")
@Entity
@Table(name = "produtos")
@NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String categoria;

	private String descricao;

	private String nome;

	private int quantidade;

	public Produto() {
	}

	@XmlElement
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@XmlElement
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@XmlElement
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlElement
	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Produto [id=" + this.getId() + ", categoria=" + this.getCategoria() + ", descricao=" + this.getDescricao() + ", nome="
				+ this.getNome() + ", quantidade=" + this.getQuantidade() + "]";
	}

}