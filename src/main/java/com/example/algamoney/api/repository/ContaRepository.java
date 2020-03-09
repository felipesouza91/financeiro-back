package com.example.algamoney.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney.api.model.Conta;
import com.example.algamoney.api.model.Usuario;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	public List<Conta> findByUsuario(Usuario usuario); 
}
