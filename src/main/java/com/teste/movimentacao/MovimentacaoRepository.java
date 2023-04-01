package com.teste.movimentacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teste.base.BaseRepository;

@Repository
public interface MovimentacaoRepository extends BaseRepository<Movimentacao> {

	@Query(value = "select m from Movimentacao m "
			+ " inner join Cliente c on c.cod = m.cliente.cod "
			+ " group by m.cod, m.cliente.nome, m.tipo "
			+ " order by m.cliente.nome asc ")
	public List<Movimentacao> listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();
	
	@Query(value = "select m from Movimentacao m "
			+ " inner join Cliente c on c.cod = m.cliente.cod "
			+ " where m.cliente.cod =:cod "
			+ " group by m.cod, m.cliente.nome, m.tipo ")
	public List<Movimentacao> listarMovimentacoesPorCliente(@Param("cod") Long cod);
	
	
}
