package com.example.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
}
