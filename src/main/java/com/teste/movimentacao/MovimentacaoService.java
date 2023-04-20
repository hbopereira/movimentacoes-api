package com.teste.movimentacao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.base.BaseService;
import com.teste.resumo.MovimentacaoResumida;

@Service
public class MovimentacaoService extends BaseService<Movimentacao, MovimentacaoRepository> {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	public List<Movimentacao> salvarMovimentacoes(List<Movimentacao> movimentacoes) {
		if (!movimentacoes.isEmpty()) {
			return movimentacaoRepository.saveAll(movimentacoes);
		} else {
			throw new RuntimeException("não existem dados a serem processados!");
		}

	}

	public Map<String, Object> listarMovimentacoesAgrupadosPorClienteETipoMovimentacao() {
		Optional<MovimentacaoResumida> movimentacao = Optional.empty();
		List<MovimentacaoResumida> movimentacoes = movimentacaoRepository
				.listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();

		Map<String, Object> mapa = new HashMap<>();
		for (MovimentacaoResumida mov : movimentacoes) {
			if (movimentacao.isEmpty()) { // adicionar o valor uma unica vez para o objeto movimentacao
				movimentacao = Optional.of(mov);
			}
			mapa.put(mov.getCod().toString(), mov);
		}
		if (movimentacao.isPresent()) {
			mapa.put("total Importação", movimentacao.get().getTotalImportacao());
			mapa.put("total Exportação", movimentacao.get().getTotalExportacao());
		}

		return mapa;
	}
}
