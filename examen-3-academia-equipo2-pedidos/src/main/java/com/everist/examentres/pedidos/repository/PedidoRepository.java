package com.everist.examentres.pedidos.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everist.examentres.pedidos.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
//	Pedido findByFecha(Date fecha);
	
}
