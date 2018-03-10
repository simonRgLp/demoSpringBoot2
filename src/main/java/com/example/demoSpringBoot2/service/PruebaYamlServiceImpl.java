package com.example.demoSpringBoot2.service;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
@ConfigurationProperties(prefix = "prueba")
public class PruebaYamlServiceImpl implements PruebaYamlService{

	@Resource
	ApplicationContext context;
	
	@Value("${username}")
	private String systemUsername;
	
	//TODO Para que funcione, se debera de crear la variable de sistema: PRUEBA_SPRING_BOOT
//	@Value("${prueba.spring.boot}")
//	private String variableSistema;
	
	//TODO Para que funcione, se deberan de crear las variables de sistema: PRUEBA_LISTASISTEMA_0_ y PRUEBA_LISTASISTEMA_1_
//	private List<String> listaSistema;
	
	private Duration tiempo;
	
	//La propiedad por defecto se sobreescribe con los valores del application.yml
	private List<String> listaE = Arrays.asList("elementoDefecto", "elementoDefecto2");
	
	private List<String> listaA;
	
	private Map<String, String> map;
	
	private Map<String, String> map2;
	
	public List<String> getListaE() {
		return listaE;
	}

	public void setListaE(List<String> listaE) {
		this.listaE = listaE;
	}

	public List<String> getListaA() {
		return listaA;
	}

	public void setListaA(List<String> listaA) {
		this.listaA = listaA;
	}
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Map<String, String> getMap2() {
		return map2;
	}

	public void setMap2(Map<String, String> map2) {
		this.map2 = map2;
	}
	
	public Duration getTiempo() {
		return tiempo;
	}

	public void setTiempo(Duration tiempo) {
		this.tiempo = tiempo;
	}

	//TODO Descomentar para que se obtengan correctamente las propiedades
//	public List<String> getListaSistema() {
//		return listaSistema;
//	}
//
//	public void setListaSistema(List<String> listaSistema) {
//		this.listaSistema = listaSistema;
//	}

	@Override
	public Flux<Map<String, String>> getPropertiesYaml(){
		
		Environment env = context.getEnvironment();
		
		String property = Binder.get(env)
				.bind("prueba.binder", String.class)
				.orElse(null);
		
		Map<String, String> properties = new HashMap<>();
		
		System.out.println("Variable properties por binder: " + property);
		properties.put("Variable binder: ", property);
		
//		System.out.println("Variable de sistema: " + variableSistema);
//		properties.put("Variable de sistema: ", variableSistema);
		
		System.out.println("Usuario del sistema: " + systemUsername);
		properties.put("Usuario del sistema: ", systemUsername);
		
		System.out.println("Variable tiempo: " + tiempo.toMinutes() + " en segundos es: " + tiempo.getSeconds());
		properties.put("Variable tiempo en minutos: ", tiempo.toString());
		
//		for(int i = 0; i< listaSistema.size();i++) {
//			System.out.println("Valores de la lista de sistema: " + i + " - " + listaSistema.get(i));
//			properties.put("listaSistema - " + i, listaSistema.get(i));
//		}
		
		for(int i = 0; i< listaE.size();i++) {
			System.out.println("Valores de la lista estandar: " + i + " - " + listaE.get(i));
			properties.put("listaE - " + i, listaE.get(i));
		}
		
		for(int i = 0; i< listaA.size();i++) {
			System.out.println("Valores de la lista abreviada: " + i + " - " + listaA.get(i));
			properties.put("listaA - " + i, listaA.get(i));
		}
		
		for(Object obj: map.keySet().toArray()){
			System.out.println("Map: " + obj.toString() + " - " + map.get(obj.toString()));
			properties.put("Map - " + obj.toString(), map.get(obj.toString()));
		}
		
		for(Object obj: map2.keySet().toArray()){
			System.out.println("Map compuesto: " + obj.toString()  + " - " + map2.get(obj.toString()));
			properties.put("Map Compuesto - " + obj.toString(), map2.get(obj.toString()));
		}
		
		return Flux.just(properties);
		
	}
	
}
