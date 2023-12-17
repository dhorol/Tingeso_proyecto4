package com.example.backendprofesoresservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BackendProfesoresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendProfesoresServiceApplication.class, args);
	}

}
