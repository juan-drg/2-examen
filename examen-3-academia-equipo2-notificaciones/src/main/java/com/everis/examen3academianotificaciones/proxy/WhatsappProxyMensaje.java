package com.everis.examen3academianotificaciones.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.everis.examen3academianotificaciones.responses.Mensaje;
import com.everis.examen3academianotificaciones.responses.MensajeResponse;

@FeignClient(name="whatzmeapi", url="https://whatzmeapi.com:10501/rest/api/enviar-mensaje?token=877be9b47ac39dcbdac80d4fff18e554352abc13")
public interface WhatsappProxyMensaje {
	
	@PostMapping
	public MensajeResponse enviaMensaje(@RequestBody Mensaje mensaje);
}
