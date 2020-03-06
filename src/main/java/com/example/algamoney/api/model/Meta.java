package com.example.algamoney.api.model;

import java.math.BigDecimal;

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
@Table(name="meta")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Meta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long codigo;
	
	private Long descricao;
	
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;

}
