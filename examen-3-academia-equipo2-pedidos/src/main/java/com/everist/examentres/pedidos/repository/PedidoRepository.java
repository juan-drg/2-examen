package com.everist.examentres.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everist.examentres.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
