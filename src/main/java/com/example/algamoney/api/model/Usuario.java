package com.example.algamoney.api.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="usuario")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
	
	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	@EqualsAndHashCode.Include
	@Column(columnDefinition = "AUTO_INCREMENT")
	private Long codigo;
	
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	private String senha;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_permissao", joinColumns=@JoinColumn(name="codigo_usuario"),
	inverseJoinColumns= @JoinColumn(name="codigo_permissao"))
	private List<Permissao> permissoes;
	
}
