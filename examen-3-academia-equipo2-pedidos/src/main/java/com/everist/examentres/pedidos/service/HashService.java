package com.everist.examentres.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everist.examentres.pedidos.model.PedidoHasProducto;
import com.everist.examentres.pedidos.repository.PedidoHasProductoRepository;

@Service
public class HashService {

	@Autowired
	private PedidoHasProductoRepository pedidoHasProductoRepository;
	
	public PedidoHasProducto insertar(PedidoHasProducto pedidoHasProducto) {
		return  pedidoHasProductoRepository.save(pedidoHasProducto);	
	
	}
}
