package com.everis.examen3academianotificaciones.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.everis.examen3academianotificaciones.components.NotificacionParametrosComponent;
import com.everis.examen3academianotificaciones.model.Cliente;
import com.everis.examen3academianotificaciones.model.Pedido;
import com.everis.examen3academianotificaciones.model.Producto;
import com.everis.examen3academianotificaciones.responses.Mensaje;
import com.everis.examen3academianotificaciones.responses.MensajeResponse;
import com.everis.examen3academianotificaciones.responses.MensajeUbicacion;
import com.everis.examen3academianotificaciones.responses.PedidoResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("notificaciones")
public class NotificacionController {

	@Autowired
	private NotificacionParametrosComponent datosConfiguracion;

	@GetMapping("/config")
	public NotificacionParametrosComponent listarConfiguracion() {
		return datosConfiguracion;
	}

	@PostMapping("/mensajes")
	public List<MensajeResponse> mensajes(@RequestBody PedidoResponse pedidoResponse) {
		// "(email,whatsapp,ambas)"
//		if(datosConfiguracion.getEmaildestino() == null) {
//			datosConfiguracion.setEmaildestino("ing.juan.acc@gmail.com");
//		}
//		if(datosConfiguracion.getTiponotificacion() == null) {
//			datosConfiguracion.setTiponotificacion("(email,whatsapp,ambas)");
//		}
//		if(datosConfiguracion.getWhatzmeapitoken() == null) {
//			datosConfiguracion.setTiponotificacion("12345");
//		}
//		if(datosConfiguracion.getWhatsappdestino() == null) {
//			datosConfiguracion.setWhatsappdestino("525537178391");;
//		}
		//nnncas
		
		List<MensajeResponse> respuestas = new ArrayList<>();
		Pedido pedido = pedidoResponse.getPedido();
		List<Producto> productos = pedidoResponse.getProductos();
		Cliente cliente = pedido.getCliente();
		String productosCadena = "";
		for(Producto objProducto : productos) {
			productosCadena = productosCadena + objProducto.toString();
		}
		if (datosConfiguracion.getTiponotificacion().indexOf("ambas")>-1) {
			respuestas = enviarmensaje(productosCadena.toString(),cliente);
			
			MensajeResponse respuestaCorreo = enviarCorreo(datosConfiguracion.getEmaildestino(), "Este es el pedido\n" , "\nDatos de los productos \n"+ productosCadena.toString()+  "Datos del cliente " +cliente.toString());
			respuestas.add(respuestaCorreo);
		}else {
			if (datosConfiguracion.getTiponotificacion().indexOf("email")>-1) {
				MensajeResponse respuestaCorreo = enviarCorreo(datosConfiguracion.getEmaildestino(), "Este es el pedido\n" , "\nDatos de los productos \n"+ productosCadena.toString()+  "Datos del cliente " +cliente.toString());
				respuestas.add(respuestaCorreo);
			}
			if (datosConfiguracion.getTiponotificacion().indexOf("whatsapp")>-1) {
				respuestas = enviarmensaje(productosCadena.toString(),cliente);
			}
		}
		return respuestas;
	}

	public List<MensajeResponse> enviarmensaje(String listaproductos, Cliente cliente) {
		List<MensajeResponse> respuestas = new ArrayList<>();
		try {
			String urlMensaje = "https://whatzmeapi.com:10501/rest/api/enviar-mensaje?token="
					+ datosConfiguracion.getWhatzmeapitoken();
			String urlUbicacion = "https://whatzmeapi.com:10501/rest/api/enviar-ubicacion?token="
					+ datosConfiguracion.getWhatzmeapitoken();
			Mensaje mensaje = new Mensaje();
			mensaje.setNumero(datosConfiguracion.getWhatsappdestino());
			mensaje.setMensaje("Esta es la lista de productos\n" + listaproductos);
			RestTemplate restTemplate = new RestTemplate();
			String respuestaMensaje = new RestTemplate().postForObject(urlMensaje, mensaje, String.class);
			ObjectMapper objectMapper = new ObjectMapper();
			MensajeResponse exito = objectMapper.readValue(respuestaMensaje, new TypeReference<MensajeResponse>() {
			});
			respuestas.add(exito);
			MensajeUbicacion mensajeUbicacion = new MensajeUbicacion();
			mensajeUbicacion.setNumero(datosConfiguracion.getWhatsappdestino());
			// Obtener los valores desde un cliente
			mensajeUbicacion.setLatitud(cliente.getLatitud());
			mensajeUbicacion.setLongitud(cliente.getLongitud());
			mensajeUbicacion.setDireccion(cliente.getNombre());
			String respuestaUbicacion = new RestTemplate().postForObject(urlUbicacion, mensajeUbicacion, String.class);
			MensajeResponse exito2 = objectMapper.readValue(respuestaMensaje, new TypeReference<MensajeResponse>() {
			});
			respuestas.add(exito2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuestas;
	}

	public MensajeResponse enviarCorreo(String email, String asunto, String texto) {

		String remitente = "academiaeveris";
		MensajeResponse respuesta = new MensajeResponse();
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", "tecguru$");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipients(Message.RecipientType.TO, email);
			message.setSubject(asunto);
			message.setText(texto);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, "tecguru$");
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			respuesta.setExito("true");
			respuesta.setCodigo("");
			respuesta.setInstancia("Gmail");
			respuesta.setMensajeError("");
			respuesta.setRespuesta("EL correo fue enviado de manera exitosa");
		} catch (MessagingException me) {
			respuesta.setCodigo("false");
			respuesta.setCodigo("");
			respuesta.setInstancia("Gmail");
			respuesta.setMensajeError("Error (1)");
			respuesta.setRespuesta("EL correo no fue enviado");
		}
		return respuesta;
	}

}
