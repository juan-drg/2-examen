package com.everis.examen3academianotificaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

public class Examen3AcademiaEquipo2NotificacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen3AcademiaEquipo2NotificacionesApplication.class, args);
	}

}
