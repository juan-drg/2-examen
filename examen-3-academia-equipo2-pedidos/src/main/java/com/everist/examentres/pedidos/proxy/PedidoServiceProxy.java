package com.everist.examentres.pedidos.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pedido-service")
@RibbonClient(name = "pedido-service")
public class PedidoServiceProxy {

	@PostMapping("pedido/")
	public PedidoResponses retrieveProducto(Pedido pedido);
}
