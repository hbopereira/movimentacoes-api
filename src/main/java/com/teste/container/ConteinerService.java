package com.teste.container;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.base.BaseService;

@Service
public class ConteinerService extends BaseService<Conteiner, ConteinerRepository> {

	@Autowired
	private ConteinerRepository conteinerRepository;

	public void salvarContainer(Conteiner container) {
		// conteinerRepository.findAll().forEach();
		List<Conteiner> lista = conteinerRepository.findAll();
		for (Conteiner c : lista) {
			if (c.getNumero().equals(container.getNumero())) {
				throw new RuntimeException("não pode salvar um container com o mesmo numero para mais de um cliente");
			}
		}
		conteinerRepository.save(container);
	}

}
