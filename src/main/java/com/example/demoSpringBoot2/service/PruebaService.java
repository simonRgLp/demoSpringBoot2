package com.example.demoSpringBoot2.service;

import java.util.Map;

import reactor.core.publisher.Flux;

public interface PruebaService {

	public Flux<Map<String, String>> getProperties();
	
}
