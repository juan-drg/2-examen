package com.everist.examentres.pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
<<<<<<< Updated upstream
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
=======

@SpringBootApplication
@EnableDiscoveryClient

>>>>>>> Stashed changes
public class Examen3AcademiaEquipo2PedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen3AcademiaEquipo2PedidosApplication.class, args);
	}

}
