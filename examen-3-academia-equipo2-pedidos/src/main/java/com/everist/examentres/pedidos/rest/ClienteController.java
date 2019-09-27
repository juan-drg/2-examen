package com.everist.examentres.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private Environment environment;
	
	public Cliente consultar(int id) {
		return clienteService.findById(id);
	}
	

}
