package com.everist.examentres.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
}
