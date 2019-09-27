package com.everist.examentres.pedidos.rest;

import java.util.Date;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.model.Producto;
import com.everist.examentres.pedidos.responses.PedidoResponse;
import com.everist.examentres.pedidos.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private Environment environment;
	
	
	@PostMapping("/pedido/cliente/{cliente}/producto/{producto}")
	public PedidoResponse insertarPedido(@PathVariable int idcliente, @PathVariable int idproducto) {
		
		Pedido pedido = new Pedido();
		
		Cliente cliente = ClienteService.buscarCliente(idcliente);
		Producto producto =   ProductoService.buscarProducto(idproducto);
		
		PedidoResponse response = new PedidoResponse();
		
		try {
			pedido.setFechahoraentrega(new Date());
			pedido.setFechahoraregistro(new Date());
			pedido.setCliente(cliente.getIdcliente());
			response.setSuccessful(true);
			response.setMessage("Pedido Insertado");   
		}catch (Exception e) {
			response.setMessage("Error al insertar pedido");
			response.setSuccessful(true);
		}
			}
	
}
