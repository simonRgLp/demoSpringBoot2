package com.example.demoSpringBoot2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demoSpringBoot2.dto.CustomEndpoint;

@SpringBootApplication
public class DemoSpringBoot2Application {

	@Bean
	public CustomEndpoint customEndpoint() {
		return new CustomEndpoint();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBoot2Application.class, args);
	}
}
