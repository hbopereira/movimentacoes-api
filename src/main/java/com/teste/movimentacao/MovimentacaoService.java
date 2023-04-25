package com.teste.movimentacao;

import java.math.BigDecimal;
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
		Optional<Long> totalImportacao = Optional.empty();
		Optional<Long> totalExportacao = Optional.empty();
		List<MovimentacaoResumida> movimentacoes = movimentacaoRepository
				.listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();

		Map<String, Object> mapa = new HashMap<>();
		for (MovimentacaoResumida mov : movimentacoes) {
			mapa.put(mov.getCod().toString(), mov);
		}
		totalImportacao = Optional.of(movimentacoes.stream().mapToLong(p-> p.getTotalImportacao()).sum());
		totalExportacao = Optional.of(movimentacoes.stream().mapToLong(p-> p.getTotalExportacao()).sum());
		
		if ((totalImportacao.isPresent()) && (totalExportacao.isPresent())) {
			mapa.put("total geral Importação", totalImportacao);
			mapa.put("total geral Exportação", totalExportacao);
		}

		return mapa;
	}
	
	
}
