package com.everist.examentres.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everist.examentres.pedidos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
