package com.everist.examentres.pedidos.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido insertar(Pedido pedido) {
		return  pedidoRepository.save(pedido);	
	}
	
//	public int buscar(Date fecha) {
//		return pedidoRepository.findByFecha(fecha).getIdpedido();
//	}
	
	
}
