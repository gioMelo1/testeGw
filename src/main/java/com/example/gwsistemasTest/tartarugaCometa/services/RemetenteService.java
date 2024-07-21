package com.example.gwsistemasTest.tartarugaCometa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwsistemasTest.tartarugaCometa.model.Remetente;
import com.example.gwsistemasTest.tartarugaCometa.repositorys.RemetenteRepository;

@Service
public class RemetenteService {

	@Autowired
	private RemetenteRepository repositorio;
	
	public List<Remetente> listarRemetente(){
		return repositorio.findAll();
	}
	
	public void cadastrarRemetente (Remetente remetente) {
		repositorio.save(remetente);
	}
	
	public Remetente iniciarEditar(Long id) {
		return repositorio.findById(id).get();
	}
	
	public void deleteRemetente(Long id) {
		repositorio.delete(repositorio.findById(id).get());
	}
}
