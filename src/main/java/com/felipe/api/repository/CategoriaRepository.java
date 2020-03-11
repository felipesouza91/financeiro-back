package com.felipe.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
