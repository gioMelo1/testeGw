package com.example.gwsistemasTest.tartarugaCometa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gwsistemasTest.tartarugaCometa.model.Produto;
import com.example.gwsistemasTest.tartarugaCometa.services.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService servico;

	@GetMapping
	public ModelAndView listarProdutos() {
		ModelAndView page = new ModelAndView();
		page.setViewName("listarProdutos");

		List<Produto> produtos = servico.listarProdutos();
		page.addObject("list_products", produtos);
			
		return page;
	}
	
	@GetMapping("/formProduto")
	public ModelAndView formProdutos() {
		ModelAndView page = new ModelAndView();
		page.setViewName("formProdutos");

		Produto produto = new Produto();
		page.addObject("produto", produto);

		return page;
	}
	
	@PostMapping("/cadastrarProduto")
	public String cadastrarProdutos(Produto produto) {
		servico.cadastrarProduto(produto);
			
		return "redirect:/produto";
	}
	
	@GetMapping(path = "/formProduto/{id}")
	public ModelAndView iniciarEditar(@PathVariable("id") Long id) {
		ModelAndView page = new ModelAndView();
		page.setViewName("formProdutos");

		Produto produto = servico.iniciarEditar(id);
		page.addObject("produto", produto);

		return page;
	}
	
	@GetMapping("/deletarProduto/{id}")
	public String deleteProduto(@PathVariable("id") Long id) {
		servico.deleteProduto(id);
		return "redirect:/produto";
	}
}
