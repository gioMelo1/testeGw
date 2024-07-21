package com.example.gwsistemasTest.tartarugaCometa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwsistemasTest.tartarugaCometa.model.Entrega;
import com.example.gwsistemasTest.tartarugaCometa.repositorys.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private EntregaRepository repository;
	
	public List<Entrega> listarEntregas() {
		return repository.findAll();
	}

	public void cadastrarEntrega(Entrega entrega) {
		repository.save(entrega);
		
	}

	public Entrega iniciarEditar(Long id) {
		return repository.findById(id).get();
	}

	public void deleteEntrega(Long id) {
		repository.delete(repository.findById(id).get());
	}
}
