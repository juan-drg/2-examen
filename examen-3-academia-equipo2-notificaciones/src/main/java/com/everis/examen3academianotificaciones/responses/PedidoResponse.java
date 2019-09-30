package com.everis.examen3academianotificaciones.responses;


import java.util.List;

import com.everis.examen3academianotificaciones.model.Pedido;
import com.everis.examen3academianotificaciones.model.Producto;


public class PedidoResponse {
	
	
	private boolean successful;
	private String message;
	private Pedido pedido;
	private List<Producto> productos;
	private int port;
	
	public boolean isSuccessful() {
		return successful;
	}
	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}
