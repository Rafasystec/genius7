package com.genius7.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genius7.request.RequestCredential;
import com.genius7.util.TokenUtil;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager atManager;
	@Autowired
	private TokenUtil tokenUtil;
	public ResponseEntity<?> authenticate(@RequestBody @Valid RequestCredential request) {
		try {
			atManager.authenticate(request.getAuthentication());
			String token = tokenUtil.getToken(request);
			System.out.println(token);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
		
		
	}
}
