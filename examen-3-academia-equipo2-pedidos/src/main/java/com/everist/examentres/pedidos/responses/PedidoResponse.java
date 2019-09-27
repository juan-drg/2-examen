package com.everist.examentres.pedidos.responses;


import com.everist.examentres.pedidos.model.Pedido;

public class PedidoResponse {
	
	
	private boolean successful;
	private String message;
	private Pedido value;
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
	public Pedido getValue() {
		return value;
	}
	public void setValue(Pedido value) {
		this.value = value;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	
	
}
