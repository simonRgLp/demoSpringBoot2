package com.example.demoSpringBoot2.dto;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="custom", enableByDefault = true)
public class CustomEndpoint {

	@ReadOperation
	public ResponseEntity<String> getCustomize() {
		return new ResponseEntity<>("Custom endpoint", HttpStatus.OK);
	}
	
	@WriteOperation
	public ResponseEntity<Void> setCustomize(@Selector String arg0) {
		System.out.println("Custom endpoint for " + arg0);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteOperation
	public ResponseEntity<Void> delCustomize(@Selector String arg0) {
		System.out.println("Delete custom endpoint for " + arg0);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
