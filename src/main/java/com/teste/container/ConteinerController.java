package com.teste.container;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.base.BaseController;

@RestController
@RequestMapping("/api/conteiners")
public class ConteinerController extends BaseController<Conteiner,ConteinerRepository, ConteinerService> {

}
