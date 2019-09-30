package com.everist.examentres.pedidos.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.model.PedidoHasProducto;
import com.everist.examentres.pedidos.model.Producto;
import com.everist.examentres.pedidos.request.PedidoRequest;
import com.everist.examentres.pedidos.responses.PedidoResponse;
import com.everist.examentres.pedidos.service.ClienteService;
import com.everist.examentres.pedidos.service.HashService;
import com.everist.examentres.pedidos.service.PedidoService;
import com.everist.examentres.pedidos.service.ProductoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private HashService hashService;
	
	@PostMapping("/pedido/")
	public PedidoResponse insertarPedido(@RequestBody PedidoRequest pedidoRecibido) {
		
		Pedido pedido = pedidoRecibido.getPedido();
		Cliente cliente = clienteService.findById(pedido.getCliente().getIdcliente());
		Producto producto =  productoService.findById(pedidoRecibido.getProducto().getIdproducto());
		
		PedidoResponse response = new PedidoResponse();
		
		try {
			pedido.setFechahoraentrega(new Date());
			pedido.setFechahoraregistro(pedido.getFechahoraentrega());
			pedido.setCliente(cliente);
			response.setSuccessful(true);
			response.setValue(pedido);
			response.setMessage("Pedido Insertado");
			
			Pedido pedidoRegistrado = pedidoService.insertar(pedido);
			
//			pedido.setIdpedido(pedidoService.buscar(pedido.getFechahoraentrega()));
			PedidoHasProducto pedidoHasProducto = new PedidoHasProducto();
			pedidoHasProducto.setPedido(pedidoRegistrado);
			pedidoHasProducto.setProducto(producto);
			
			hashService.insertar(pedidoHasProducto);
			
		}catch (Exception e) {
			response.setMessage("Error al insertar pedido");
			response.setSuccessful(true);
		}
		return response;
	}
	
	
}
