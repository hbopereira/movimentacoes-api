package com.teste.container;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.base.BaseService;

@Service
public class ConteinerService extends BaseService<Conteiner, ConteinerRepository> {

	@Autowired
	private ConteinerRepository conteinerRepository;

	public void salvarContainer(Conteiner container) {
		Optional<Conteiner> cont = conteinerRepository.findAll().stream()
				.filter(c -> c.getNumero().equals(container.getNumero())).findFirst();
		if (!cont.isEmpty()) {
			throw new RuntimeException("não pode salvar um container com o mesmo numero para mais de um cliente");
		}
		conteinerRepository.save(container);
	}

}
