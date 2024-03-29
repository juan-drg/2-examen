package com.everis.examen3academianotificaciones.model;
// Generated 27/09/2019 01:24:25 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Cliente generated by hbm2java
 */
@Component
@ConfigurationProperties("config")
public class Cliente implements java.io.Serializable {

	private int idcliente;
	private String nombre;
	private String latitud;
	private String longitud;
//	private Set<Pedido> pedidos = new HashSet<Pedido>(0);

	public Cliente() {
	}

	public Cliente(int idcliente, String nombre, String latitud, String longitud) {
		this.idcliente = idcliente;
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
	}

//	public Cliente(int idcliente, String nombre, String latitud, String longitud, Set<Pedido> pedidos) {
//		this.idcliente = idcliente;
//		this.nombre = nombre;
//		this.latitud = latitud;
//		this.longitud = longitud;
//		this.pedidos = pedidos;
//	}

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Cliente [idcliente=" + idcliente + ", nombre=" + nombre + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}

//	public Set<Pedido> getPedidos() {
//		return this.pedidos;
//	}
//
//	public void setPedidos(Set<Pedido> pedidos) {
//		this.pedidos = pedidos;
//	}
	
	

}
