package com.everist.examentres.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(int id) {
		return clienteRepository.findById(id).get();
	}
}
