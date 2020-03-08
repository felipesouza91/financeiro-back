package com.example.algamoney.api.core.secutiry.authorizationserver;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.algamoney.api.model.Usuario;

import lombok.Getter;

@Getter
public class AuthUser extends User{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String fullName;
	
	public AuthUser(Usuario usuario, Collection<GrantedAuthority> collection ) {
		super(usuario.getEmail(), usuario.getSenha(), collection);
		this.fullName = usuario.getNome();
		this.id = usuario.getCodigo();
	}

}
