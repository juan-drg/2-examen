package com.everist.examentres.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.service.ClienteService;

@RestController
@RequestMapping("/clienteconsulta")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	
	@GetMapping("/cliente/{id}")
	public Cliente buscarCliente(@PathVariable int id) {
		return clienteService.findById(id);
	}
	

}
