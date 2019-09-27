package com.everist.examentres.pedidos.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everist.examentres.pedidos.model.Producto;
import com.everist.examentres.pedidos.service.ProductoService;

@RestController
@RequestMapping("/productoconsulta")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/producto/id/{id}")
	public Producto consultar(@PathVariable int id) {
		return productoService.findById(id);
	} 
	

}
