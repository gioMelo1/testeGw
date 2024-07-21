package com.example.gwsistemasTest.tartarugaCometa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.gwsistemasTest.tartarugaCometa.model.Remetente;
import com.example.gwsistemasTest.tartarugaCometa.services.RemetenteService;

@Controller 
@RequestMapping ("/remetente")
public class RemetenteController {

	@Autowired
	private RemetenteService servico;
	
	@GetMapping
	public ModelAndView listarRemetentes () {
		ModelAndView page = new ModelAndView();
		page.setViewName("listarRemetentes");
		
		List<Remetente> remetentes = servico.listarRemetente();
		page.addObject("listar_remetente", remetentes);
		
		return page;
	}
	
	@GetMapping("/formRemetente")
	public ModelAndView fomrRemetente() {
		ModelAndView page = new ModelAndView();
		page.setViewName("formRemetente");
		
		Remetente remetente = new Remetente();
		page.addObject("remetente", remetente);
		
		return page;
	}
	
	@PostMapping("/cadastrarRemetente")
	public String cadastrarRemetentes(Remetente remetente) {
		servico.cadastrarRemetente(remetente);
		
		return "redirect:/remetente";
	}
	
	@GetMapping(path = "/formRemetente/{id}")
	public ModelAndView iniciarEditar(@PathVariable ("id") Long id) {
		ModelAndView page = new ModelAndView();
		page.setViewName("formRemetente");
		
		Remetente remetente = servico.iniciarEditar(id);
		page.addObject("remetente", remetente);
		
		return page;
	}
	
	@GetMapping("/deletarRemetente/{id}")
	public String deleteRemetente (@PathVariable("id") Long id) {
		servico.deleteRemetente(id);
		return "redirect:/remetente";
	}
}


