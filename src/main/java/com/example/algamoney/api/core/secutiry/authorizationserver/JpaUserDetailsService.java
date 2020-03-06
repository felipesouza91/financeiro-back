package com.example.algamoney.api.core.secutiry.authorizationserver;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.repository.UsuarioRepository;


@Service
public class JpaUserDetailsService implements UserDetailsService {
	
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Usuario ou senha invalida"));
		
		return new AuthUser(usuario, getAuthorities(usuario));
	}

	private Collection<GrantedAuthority> getAuthorities(Usuario usuario) {
		return usuario.getPermissoes().stream()
				.map(permissao -> new SimpleGrantedAuthority(permissao.getId().toString()))
				.collect(Collectors.toSet());
	}
}
