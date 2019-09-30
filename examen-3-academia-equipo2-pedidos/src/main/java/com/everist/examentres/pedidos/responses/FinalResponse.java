package com.everist.examentres.pedidos.responses;

import java.util.List;

public class FinalResponse {
	
	Boolean exito;
	String codigo;
	String mensaje;
	PedidoResponse pedidoResponse;
	List<MensajeResponse> wattsAppResponse;
	
	public Boolean getExito() {
		return exito;
	}
	public void setExito(Boolean exito) {
		this.exito = exito;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public PedidoResponse getPedidoResponse() {
		return pedidoResponse;
	}
	public void setPedidoResponse(PedidoResponse pedidoResponse) {
		this.pedidoResponse = pedidoResponse;
	}
	public List<MensajeResponse> getWattsAppResponse() {
		return wattsAppResponse;
	}
	public void setWattsAppResponse(List<MensajeResponse> wattsAppResponse) {
		this.wattsAppResponse = wattsAppResponse;
	}
	
}
