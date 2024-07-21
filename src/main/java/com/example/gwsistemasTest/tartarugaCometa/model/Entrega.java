package com.example.gwsistemasTest.tartarugaCometa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Entrega {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "remetente_id")
	private Remetente remetente;

	@ManyToOne
    @JoinColumn(name = "destinatario_id")
	private Destinatario destinatario;

	@ManyToOne
    @JoinColumn(name = "produto_id")
	private Produto produto;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Remetente getRemetente() {
		return remetente;
	}

	public void setRemetente(Remetente remetente) {
		this.remetente = remetente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}
