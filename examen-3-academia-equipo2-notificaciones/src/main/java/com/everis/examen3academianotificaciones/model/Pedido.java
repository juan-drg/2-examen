package com.everis.examen3academianotificaciones.model;
// Generated 27/09/2019 01:24:25 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Component
@ConfigurationProperties("config")
public class Pedido implements java.io.Serializable {

	private int idpedido;
	private Cliente cliente;
	private Date fechahoraregistro;
	private Date fechahoraentrega;
	@JsonIgnore
	private Set<PedidoHasProducto> pedidoHasProductos = new HashSet<PedidoHasProducto>(0);

	public Pedido() {
	}

	public Pedido(int idpedido, Cliente cliente, Date fechahoraregistro, Date fechahoraentrega) {
		this.idpedido = idpedido;
		this.cliente = cliente;
		this.fechahoraregistro = fechahoraregistro;
		this.fechahoraentrega = fechahoraentrega;
	}

	public Pedido(int idpedido, Cliente cliente, Date fechahoraregistro, Date fechahoraentrega,
			Set<PedidoHasProducto> pedidoHasProductos) {
		this.idpedido = idpedido;
		this.cliente = cliente;
		this.fechahoraregistro = fechahoraregistro;
		this.fechahoraentrega = fechahoraentrega;
		this.pedidoHasProductos = pedidoHasProductos;
	}

	public int getIdpedido() {
		return this.idpedido;
	}

	public void setIdpedido(int idpedido) {
		this.idpedido = idpedido;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFechahoraregistro() {
		return this.fechahoraregistro;
	}

	public void setFechahoraregistro(Date fechahoraregistro) {
		this.fechahoraregistro = fechahoraregistro;
	}

	public Date getFechahoraentrega() {
		return this.fechahoraentrega;
	}

	public void setFechahoraentrega(Date fechahoraentrega) {
		this.fechahoraentrega = fechahoraentrega;
	}

	public Set<PedidoHasProducto> getPedidoHasProductos() {
		return this.pedidoHasProductos;
	}

	public void setPedidoHasProductos(Set<PedidoHasProducto> pedidoHasProductos) {
		this.pedidoHasProductos = pedidoHasProductos;
	}

}
