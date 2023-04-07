package com.teste.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.base.BaseController;

@RestController
@RequestMapping("/api/conteiners")
public class ConteinerController extends BaseController<Conteiner, ConteinerRepository, ConteinerService> {

	@Autowired
	private ConteinerService conteinerService;

	@PostMapping(value = "/salvarConteiner")
	public void salvarContainer(@RequestBody Conteiner conteiner) {
		conteinerService.salvarContainer(conteiner);
	}
}
