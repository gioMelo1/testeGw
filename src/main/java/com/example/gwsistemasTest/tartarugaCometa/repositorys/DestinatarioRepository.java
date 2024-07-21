package com.example.gwsistemasTest.tartarugaCometa.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gwsistemasTest.tartarugaCometa.model.Destinatario;

@Repository
public interface DestinatarioRepository extends JpaRepository<Destinatario, Long>{
	

}
