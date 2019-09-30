package com.everis.examen3academianotificaciones.model;
// Generated 27/09/2019 01:24:25 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Producto generated by hbm2java
 */

@Component
@ConfigurationProperties("config")
public class Producto implements java.io.Serializable {

	private int idproducto;
	private String nombre;
	private double precio;
	private String url;
	@JsonIgnore
	private Set<PedidoHasProducto> pedidoHasProductos = new HashSet<PedidoHasProducto>(0);

	public Producto() {
	}

	public Producto(int idproducto, String nombre, double precio, String url) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
	}

	public Producto(int idproducto, String nombre, double precio, String url,
			Set<PedidoHasProducto> pedidoHasProductos) {
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.url = url;
		this.pedidoHasProductos = pedidoHasProductos;
	}

	
	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	public Set<PedidoHasProducto> getPedidoHasProductos() {
		return this.pedidoHasProductos;
	}

	public void setPedidoHasProductos(Set<PedidoHasProducto> pedidoHasProductos) {
		this.pedidoHasProductos = pedidoHasProductos;
	}

}
