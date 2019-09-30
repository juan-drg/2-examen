package com.everis.examen3academianotificaciones.model;
// Generated 27/09/2019 01:24:25 PM by Hibernate Tools 5.2.12.Final


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("config")
public class PedidoHasProducto implements java.io.Serializable {

	private int id;
	private Pedido pedido;
	private Producto producto;

	public PedidoHasProducto() {
	}

	public PedidoHasProducto(int id, Pedido pedido, Producto producto) {
		this.id = id;
		this.pedido = pedido;
		this.producto = producto;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
