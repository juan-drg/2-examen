package com.everist.examentres.pedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.everist.examentres.pedidos.model.Producto;
import com.everist.examentres.pedidos.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	public Producto findById(int id) {
		return productoRepository.findById(id).get();
	}
}
