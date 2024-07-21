package com.example.gwsistemasTest.tartarugaCometa.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gwsistemasTest.tartarugaCometa.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}