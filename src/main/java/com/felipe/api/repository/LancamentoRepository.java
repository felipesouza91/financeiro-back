package com.felipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.api.model.Lancamento;
import com.felipe.api.repository.lancamento.LancamentoRepositoryQuery;


public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}
