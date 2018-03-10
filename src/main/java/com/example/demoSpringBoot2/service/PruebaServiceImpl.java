package com.example.demoSpringBoot2.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
@PropertySource("classpath:app.properties")
@ConfigurationProperties(prefix = "prueba")
public class PruebaServiceImpl implements PruebaService{

	private List<String> lista;
	
	private List<String> listaP;
	
	@Value("${prueba.clavecompuesta}")
	private String claveCompuesta1;
	
	@Value("${prueba.clavecompuesta2}")
	private String claveCompuesta2;
	
	@Value("${prueba.clavecompuesta3}")
	private String claveCompuesta3;
	
	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public List<String> getListaP() {
		return listaP;
	}

	public void setListaP(List<String> listaP) {
		this.listaP = listaP;
	}

	public Flux<Map<String, String>> getProperties(){
		
		Map<String, String> properties = new HashMap<>();
		
		for(int i = 0; i < lista.size(); i++) {
			
			System.out.println("Properties de fichero properties en lista estandar: " + lista.get(i));
			properties.put("lista - " + i, lista.get(i));
		}
		
		for(int i = 0; i < listaP.size(); i++) {
			
			System.out.println("Properties de fichero properties en lista abreviada: " + listaP.get(i));
			properties.put("listaP - " + i, listaP.get(i));
		}
		
		System.out.println("Clave compuesta 1: " + claveCompuesta1);
		properties.put("Clave compuesta 1: ", claveCompuesta1);
		System.out.println("Clave compuesta 2: " + claveCompuesta2);
		properties.put("Clave compuesta 2: ", claveCompuesta2);
		System.out.println("Clave compuesta 3: " + claveCompuesta3);
		properties.put("Clave compuesta 3: ", claveCompuesta3);
		
		return Flux.just(properties);
	}
	
	
}
