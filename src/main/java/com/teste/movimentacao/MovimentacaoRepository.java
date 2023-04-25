package com.teste.movimentacao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teste.base.BaseRepository;
import com.teste.resumo.MovimentacaoResumida;

@Repository
public interface MovimentacaoRepository extends BaseRepository<Movimentacao> {

	@Query(value="select m.cod, cl.nome, c.categoria, c.status, c.tipo, "
			+ "c.numero, m.tipom, m.datahi, m.datahf,"
			+ " (select COUNT(*) from conteiner co where co.cod = m.conteiner_cod and co.categoria = 'Importacao') as totalImportacao, "
			+ " (select COUNT(*) from conteiner co where co.cod = m.conteiner_cod and co.categoria = 'Exportacao') as totalExportacao "
			+ "from movimentacao m "
			+ "inner join conteiner c on c.cod = m.conteiner_cod "
			+ "inner join cliente cl on cl.cod = c.cliente_cod "
			+ "group by m.cod, cl.nome, m.tipom ", nativeQuery = true)
	public List<MovimentacaoResumida> listarMovimentacoesAgrupadosPorClienteETipoMovimentacao();
	
	@Query(value = "select m from Movimentacao m "
			+ " inner join Conteiner c on c.cod = m.conteiner.cod "
			+ " inner join Cliente cl on cl.cod = c.cliente.cod "
			+ " where c.cliente.cod =:cod "
			+ " group by m.cod, c.cliente.nome, m.tipom ")
	public List<Movimentacao> listarMovimentacoesPorCliente(@Param("cod") Long cod);
	
	
	
	
	
}