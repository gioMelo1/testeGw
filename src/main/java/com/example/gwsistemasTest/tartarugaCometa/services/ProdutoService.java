package com.example.gwsistemasTest.tartarugaCometa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwsistemasTest.tartarugaCometa.model.Produto;
import com.example.gwsistemasTest.tartarugaCometa.repositorys.ProdutoRepository;

@Service
public class ProdutoService {	
	
	@Autowired
	private ProdutoRepository repositorio;
	
	public List<Produto> listarProdutos(){
		return repositorio.findAll();
	}
	
	public void cadastrarProduto(Produto produto) {
		repositorio.save(produto);
	}

	public Produto iniciarEditar(Long id) {
		return repositorio.findById(id).get();
	}

	public void deleteProduto(Long id) {
		repositorio.delete(repositorio.findById(id).get());
		
	}
}
