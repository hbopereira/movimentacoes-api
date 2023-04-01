package com.teste.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {
	
	@Autowired
	private REPOSITORY repo;

	@Transactional
	public Optional<ENTITY> salvar(ENTITY entity) {
		ENTITY nova = repo.save(entity);
		return Optional.of(nova);
	}

	@Transactional
	public Optional<ENTITY> atualizar(ENTITY entidade) {
		if (repo.existsById(entidade.getCod())) {
			salvar(entidade);
			return Optional.of(entidade);
		} else {
			return Optional.empty();
		}
	}
	
	@Transactional
	public void excluir(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		}
	}
	
	public ENTITY chamarAtualizar(ENTITY entidade) {
		return atualizar(entidade)
				.orElseThrow(() -> new RuntimeException("Registro não encontrado" + entidade.getCod()));
	}
	
}
