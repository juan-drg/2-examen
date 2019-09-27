package com.everist.examentres.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everist.examentres.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido incertar(Pedido pedido) {
		return  pedidoRepository.save(pedido);	
	}
}
