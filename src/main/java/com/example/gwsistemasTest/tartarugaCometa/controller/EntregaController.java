package com.example.gwsistemasTest.tartarugaCometa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gwsistemasTest.tartarugaCometa.model.Destinatario;
import com.example.gwsistemasTest.tartarugaCometa.model.Entrega;
import com.example.gwsistemasTest.tartarugaCometa.model.Produto;
import com.example.gwsistemasTest.tartarugaCometa.model.Remetente;
import com.example.gwsistemasTest.tartarugaCometa.services.DestinatarioService;
import com.example.gwsistemasTest.tartarugaCometa.services.EntregaService;
import com.example.gwsistemasTest.tartarugaCometa.services.ProdutoService;
import com.example.gwsistemasTest.tartarugaCometa.services.RemetenteService;


@Controller
@RequestMapping("/entrega")
public class EntregaController {

	@Autowired
	private ProdutoService serviceProduto;

	@Autowired
	private RemetenteService serviceRemetente;

	@Autowired
	private DestinatarioService serviceDestinatario;

	@Autowired
	private EntregaService service;
	
	@GetMapping
	public ModelAndView listarEntregas() {
		ModelAndView page = new ModelAndView();
		page.setViewName("listarEntregas");
		List<Entrega> entregas = service.listarEntregas();

		page.addObject("list_entregas", entregas);
		return page;
	}
	
	@GetMapping("/formEntrega")
	public ModelAndView getFormEntrega() {
		ModelAndView page = new ModelAndView();
		page.setViewName("formEntrega");
		
		Entrega entrega = new Entrega();
		List<Produto> produtos = serviceProduto.listarProdutos();
		List<Remetente> remetentes = serviceRemetente.listarRemetente();
		List<Destinatario> destinatarios = serviceDestinatario.listarDestinatario();
		
		page.addObject("entrega", entrega);
		page.addObject("list_produtos", produtos);
		page.addObject("list_remententes", remetentes);
		page.addObject("list_destinatario", destinatarios);
		
		return page;
	}
	
	@PostMapping("/cadastrarEntrega")
	public String cadastrarEntrega(Entrega entrega) {
		service.cadastrarEntrega(entrega);
		return "redirect:/entrega";
		
	}

	@GetMapping("/cadastrarEntrega/{id}")
	public ModelAndView editarEntrega(@PathVariable("id") Long id) {		
		ModelAndView page = new ModelAndView();
		page.setViewName("formEditarEntrega");
		
		Entrega entrega = service.iniciarEditar(id);
		page.addObject("entrega" , entrega);
		
		return page;
		
	}
	
	@GetMapping("/deletarEntrega/{id}")
	public String deletarEntrega(@PathVariable("id") Long id) {
		service.deleteEntrega(id);
		return "redirect:/entrega";
	}
	
}
