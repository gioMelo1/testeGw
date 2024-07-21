package com.example.gwsistemasTest.tartarugaCometa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Remetente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (name = "cnpjCpf")
	private String cnpjCpf;
		
	@Column (name = "razaoSocial")
	private String razaoSocial;
	
	@Column (name = "nome")
	private String nome;
	
	@Column (name = "pessoaJuridica")
	private boolean pessoaJuridica;
	
	@Column (name = "endereco")
	private String endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpjCpf() {
		return cnpjCpf;
	}

	public void setCnpjCpf(String cnpjCpf) {
		this.cnpjCpf = cnpjCpf;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}
	
	public String isPessoaJuridicaFormatado() {
		return pessoaJuridica ? "Sim" : "Não";
	}
	
	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
