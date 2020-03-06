package com.example.algamoney.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="conta")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
	
}
