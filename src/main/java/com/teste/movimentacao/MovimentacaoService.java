package com.teste.movimentacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.base.BaseService;

@Service
public class MovimentacaoService extends BaseService<Movimentacao, MovimentacaoRepository> {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	public List<Movimentacao> salvarMovimentacoes(List<Movimentacao> movimentacoes) {
		if (!movimentacoes.isEmpty()) {
			return movimentacaoRepository.saveAll(movimentacoes);
		}else {
			throw new RuntimeException("não existem dados a serem processados!");
		}

	}
}
