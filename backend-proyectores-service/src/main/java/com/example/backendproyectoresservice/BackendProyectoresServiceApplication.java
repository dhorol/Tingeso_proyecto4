package com.example.backendproyectoresservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BackendProyectoresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProyectoresServiceApplication.class, args);
	}

}
