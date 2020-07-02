package com.genius7.controller;

import org.springframework.http.ResponseEntity;

public class SuperController {
	
	protected static <T> ResponseEntity<T> responseOK(T body) {
		return ResponseEntity.ok(body);
	}

}
