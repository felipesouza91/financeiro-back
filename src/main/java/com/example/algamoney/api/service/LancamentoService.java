package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.repository.CategoriaRepository;
import com.example.algamoney.api.repository.ContaRepository;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.service.exception.EntidadeNaoEncontradaException;

import lombok.Getter;
	
@Service
public class LancamentoService {

	@Autowired 
	@Getter
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
		
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Lancamento salvar(Lancamento lancamento) {
		try {
			this.categoriaRepository.findById(lancamento.getCategoria().getCodigo())
				.orElseThrow(() -> new EntidadeNaoEncontradaException());
			this.contaRepository.findById(lancamento.getConta().getCodigo())
				.orElseThrow(() -> new EntidadeNaoEncontradaException());
			return lancamentoRepository.save(lancamento);
		}catch (EntidadeNaoEncontradaException e) {
			throw e;
		}
	}

	public Lancamento atualizar(Long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalvo = buscarLancamentoExistente(codigo);	
		BeanUtils.copyProperties(lancamento, lancamentoSalvo, "codigo");
		return lancamentoRepository.save(lancamentoSalvo);
	}
	
	
	private Lancamento buscarLancamentoExistente(Long codigo) {
		Lancamento lancamento = lancamentoRepository.findById(codigo).get();
		if ( lancamento == null ) {
			throw new IllegalArgumentException();
		}
		return lancamento;
	}

}
