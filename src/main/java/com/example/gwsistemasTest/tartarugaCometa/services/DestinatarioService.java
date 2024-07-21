package com.example.gwsistemasTest.tartarugaCometa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwsistemasTest.tartarugaCometa.model.Destinatario;
import com.example.gwsistemasTest.tartarugaCometa.repositorys.DestinatarioRepository;

@Service
public class DestinatarioService {

	@Autowired
	private DestinatarioRepository repositorio;
	
	public List<Destinatario> listarDestinatario(){
		return repositorio.findAll();
	}
	
	public void cadastrarDestinatario (Destinatario destinatario) {
		repositorio.save(destinatario);
	}
	
	public Destinatario iniciarEditar (Long id) {
		return repositorio.findById(id).get();
	}
	
	public void deleteDestinatario(Long id) {
		repositorio.delete(repositorio.findById(id).get());
	}
}
