package com.teste.movimentacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teste.base.BaseRepository;

@Repository
public interface MovimentacaoRepository extends BaseRepository<Movimentacao> {

	@Query(value = "select m from Movimentacao m "
			+ " inner join Conteiner c on c.cod = m.conteiner.cod "
			+ " inner join Cliente cl on cl.cod = c.cliente.cod "
			+ " group by m.cod, c.cliente.nome, m.tipo "
			+ " order by c.cliente.nome asc ")
	public List<Movimentacao> listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();
	
	@Query(value = "select m from Movimentacao m "
			+ " inner join Conteiner c on c.cod = m.conteiner.cod "
			+ " inner join Cliente cl on cl.cod = c.cliente.cod "
			+ " where c.cliente.cod =:cod "
			+ " group by m.cod, c.cliente.nome, m.tipo ")
	public List<Movimentacao> listarMovimentacoesPorCliente(@Param("cod") Long cod);
	
	
}