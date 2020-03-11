package com.felipe.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.api.model.Conta;
import com.felipe.api.model.Usuario;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	public List<Conta> findByUsuario(Usuario usuario); 
}
