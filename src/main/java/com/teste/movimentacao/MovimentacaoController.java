package com.teste.movimentacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teste.base.BaseController;

@RestController
@RequestMapping("/api/movimentacoes")
public class MovimentacaoController extends BaseController<Movimentacao, MovimentacaoRepository, MovimentacaoService> {

	@Autowired
	private MovimentacaoService movimentacaoService;

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@PostMapping(value = "/salvarMovimentacoes")
	public ResponseEntity<List<Movimentacao>> salvarMovimentacoes(@RequestBody List<Movimentacao> movimentacoes) {
		List<Movimentacao> resultado = movimentacaoService.salvarMovimentacoes(movimentacoes);
		if (!resultado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/listarMovimentacoesAgrupadosPorClienteETipoMovimentacao")
	public List<Movimentacao> listarMovimentacoesAgrupadosPorClienteETipoMovimentacao() {
		return movimentacaoRepository.listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();
	}
	
	@GetMapping(value = "/listarMovimentacoesPorCliente")
	public List<Movimentacao> listarMovimentacoesPorCliente(@RequestParam("cod") Long codCliente){
		return movimentacaoRepository.listarMovimentacoesPorCliente(codCliente);
	}
}
