package com.everist.examentres.pedidos.request;

import java.util.List;

import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.model.Producto;

public class PedidoRequest {
	
	private Pedido pedido;
	private List<Producto> productos;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
}
