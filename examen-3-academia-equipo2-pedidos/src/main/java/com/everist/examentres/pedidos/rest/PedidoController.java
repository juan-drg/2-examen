package com.everist.examentres.pedidos.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Cliente;
import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.model.PedidoHasProducto;
import com.everist.examentres.pedidos.model.Producto;
import com.everist.examentres.pedidos.proxy.PedidoServiceProxy;
import com.everist.examentres.pedidos.request.PedidoRequest;
import com.everist.examentres.pedidos.responses.FinalResponse;
import com.everist.examentres.pedidos.responses.MensajeResponse;
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
	
	@Autowired
	PedidoServiceProxy pedidoServiceProxy;
	
	@PostMapping("/pedido/")
	public FinalResponse insertarPedido(@RequestBody PedidoRequest pedidoRecibido) {

		FinalResponse respuestaFinal = new FinalResponse();
		Pedido pedido = pedidoRecibido.getPedido();
		Cliente cliente = clienteService.findById(pedido.getCliente().getIdcliente());
		
		PedidoResponse response = new PedidoResponse();
		
		try {
			pedido.setFechahoraentrega(new Date());
			pedido.setFechahoraregistro(pedido.getFechahoraentrega());
			pedido.setCliente(cliente);
			response.setSuccessful(true);
			response.setPedido(pedido);
			response.setMessage("Pedido Insertado");
			
			Pedido pedidoRegistrado = pedidoService.insertar(pedido);
			
			List<Producto> productosRecibidos =  pedidoRecibido.getProductos();
			List<Producto> productosObtenidos =  new ArrayList<>();
			
			for (Producto producto : productosRecibidos) {
				int buscaId = producto.getIdproducto();
				Producto productoObtenido = productoService.findById(buscaId);
				
				PedidoHasProducto pedidoHasProducto = new PedidoHasProducto();
				pedidoHasProducto.setPedido(pedidoRegistrado);
				pedidoHasProducto.setProducto(productoObtenido);
				
				hashService.insertar(pedidoHasProducto);
				
				productosObtenidos.add(productoObtenido);
				
			}
			
			response.setProductos(productosObtenidos);
			
			List<MensajeResponse> wattsPedidoResponse = pedidoServiceProxy.retrieveNotificaciones(response);
			
			if(wattsPedidoResponse.isEmpty()) {
				respuestaFinal.setExito(false);
				respuestaFinal.setMensaje("Sin conexión a watsApp");
				respuestaFinal.setCodigo("401");
			}else {
				respuestaFinal.setExito(true);
				respuestaFinal.setMensaje("Operación éxitosa");
				respuestaFinal.setCodigo("200");
				respuestaFinal.setWattsAppResponse(wattsPedidoResponse);
				respuestaFinal.setPedidoResponse(response);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			respuestaFinal.setMensaje("Error al insertar pedido: " + e.getMessage());
			respuestaFinal.setExito(false);
		}
		return respuestaFinal;
	}
	
	
	
	
	
}
