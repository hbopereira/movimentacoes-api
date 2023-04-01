package com.teste.cliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.base.BaseController;

@RestController
@RequestMapping("api/clientes")
public class ClienteController extends BaseController<Cliente,ClienteRepository,ClienteService> {

}
