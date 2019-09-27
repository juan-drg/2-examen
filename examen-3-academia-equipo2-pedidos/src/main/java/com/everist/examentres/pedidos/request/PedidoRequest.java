package com.everist.examentres.pedidos.request;

import com.everist.examentres.pedidos.model.Pedido;
import com.everist.examentres.pedidos.model.Producto;

public class PedidoRequest {
	
	private Pedido pedido;
	private Producto producto;
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
