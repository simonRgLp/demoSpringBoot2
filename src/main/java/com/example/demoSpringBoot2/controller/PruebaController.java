package com.example.demoSpringBoot2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSpringBoot2.service.PruebaService;
import com.example.demoSpringBoot2.service.PruebaYamlService;

import reactor.core.publisher.Flux;

@RestController
public class PruebaController {

	@Autowired
	private PruebaYamlService pruebaYamlService;
	
	@Autowired
	private PruebaService pruebaService;
	
	@GetMapping("/properties_yaml")
    Flux<Map<String, String>> getPropertiesYaml() {
        return pruebaYamlService.getPropertiesYaml();
    }
	
	@GetMapping("/properties")
    Flux<Map<String, String>> getProperties() {
        return pruebaService.getProperties();
    }
	
}
