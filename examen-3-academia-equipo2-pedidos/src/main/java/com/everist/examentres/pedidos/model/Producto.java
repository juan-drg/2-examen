package com.everist.examentres.pedidos.model;
// Generated 27/09/2019 01:24:25 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Producto generated by hbm2java
 */
@Entity
@Table(name = "producto", catalog = "examen3")
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idproducto", unique = true, nullable = false)
	public int getIdproducto() {
		return this.idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	@Column(name = "nombre", nullable = false, length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "precio", nullable = false, precision = 22, scale = 0)
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Column(name = "url", nullable = false, length = 50)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
//	public Set<PedidoHasProducto> getPedidoHasProductos() {
//		return this.pedidoHasProductos;
//	}
//
//	public void setPedidoHasProductos(Set<PedidoHasProducto> pedidoHasProductos) {
//		this.pedidoHasProductos = pedidoHasProductos;
//	}

}
