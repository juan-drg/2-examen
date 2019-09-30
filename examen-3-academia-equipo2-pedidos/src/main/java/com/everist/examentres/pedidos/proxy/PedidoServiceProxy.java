package com.everist.examentres.pedidos.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everist.examentres.pedidos.responses.MensajeResponse;
import com.everist.examentres.pedidos.responses.PedidoResponse;

@FeignClient(name = "NOTIFICACION", url = "http://192.168.5.220:8080/")
public interface PedidoServiceProxy {
	
	@PostMapping("notificaciones/mensajes")
	public List<MensajeResponse> retrieveNotificaciones(@RequestBody PedidoResponse pedidoResponse);

}