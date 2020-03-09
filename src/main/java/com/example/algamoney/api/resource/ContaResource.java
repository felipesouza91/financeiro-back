package com.example.algamoney.api.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney.api.model.Conta;
import com.example.algamoney.api.model.Usuario;
import com.example.algamoney.api.repository.ContaRepository;
import com.example.algamoney.api.service.exception.EntidadeNaoEncontradaException;

@RestController
@RequestMapping("/contas")
public class ContaResource {

	@Autowired
	private ContaRepository contaRespository;
	
	@Autowired
	private Usuario usuario;
	
	@GetMapping
	public List<Conta> buscarTodos() {
		return this.contaRespository.findByUsuario(usuario);
	}
	
	@GetMapping("{id}")
	public Conta buscarPorCodigo(@PathVariable Long id) {
		Conta conta = this.contaRespository.findById(id)
					.orElseThrow(() -> new EntidadeNaoEncontradaException());
		return conta;
	}
	
	@PostMapping
	public Conta salvar(@RequestBody @Valid Conta conta) {
		return contaRespository.save(conta);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		this.contaRespository.deleteById(id);
	}
}
