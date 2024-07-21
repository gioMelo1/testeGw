package com.example.gwsistemasTest.tartarugaCometa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwsistemasTest.tartarugaCometa.model.Entrega;
import com.example.gwsistemasTest.tartarugaCometa.repositorys.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository repositorio;
	
	public List<Entrega> listarEntregas() {
		return repositorio.findAll();
	}

	public void cadastrarEntrega(Entrega entrega) {
		repositorio.save(entrega);
		
	}

	public Entrega iniciarEditar(Long id) {
		return repositorio.findById(id).get();
	}

	public void deleteEntrega(Long id) {
		repositorio.delete(repositorio.findById(id).get());
	}
}
