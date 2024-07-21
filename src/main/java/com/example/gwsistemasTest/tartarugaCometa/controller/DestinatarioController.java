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
import com.example.gwsistemasTest.tartarugaCometa.services.DestinatarioService;

@Controller
@RequestMapping ("/destinatario")
public class DestinatarioController {

	@Autowired
	private DestinatarioService servico;
	
	@GetMapping
	public ModelAndView listarDestinatario() {
		ModelAndView page = new ModelAndView();
		page.setViewName("listarDestinatario");
		
		List<Destinatario> destinatarios = servico.listarDestinatario();
		page.addObject("listar_destinatario", destinatarios);
		
		return page;
	}
	
	@GetMapping("/formDestinatario")
	public ModelAndView formDestinatario() {
		ModelAndView page = new ModelAndView();
		page.setViewName("formDestinatario");
		
		Destinatario destinatario = new Destinatario();
		page.addObject("destinatario" , destinatario);
		
		return page;
	}
	
	@PostMapping("/cadastrarDestinatario")
	public String cadastrarDestinatario(Destinatario destinatario ){
		servico.cadastrarDestinatario(destinatario);
		
		return "redirect:/destinatario";
	}
	
	@GetMapping(path = "/formDestinatario/{id}")
	public ModelAndView iniciarEditar(@PathVariable("id") Long id) {
		ModelAndView page = new ModelAndView();
		page.setViewName("formDestinatario");
		
		Destinatario destinatario = servico.iniciarEditar(id);
		page.addObject("destinatario" , destinatario);
		
		return page;
	}
	
	@GetMapping("/deletarDestinatario/{id}")
	public String deleteDestinatario(@PathVariable("id") Long id) {
		servico.deleteDestinatario (id);
		return "redirect:/destinatario";
	}
}
