package com.example.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Examen3AcademiaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Examen3AcademiaConfigServerApplication.class, args);
	}

}
