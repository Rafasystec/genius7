package com.genius7.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.genius7.model.User;
import com.genius7.request.RequestCredential;
import com.genius7.response.ResponseAuthentication;
import com.genius7.util.TokenUtil;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenUtil tokenUtil;
	@PostMapping
	public ResponseEntity<ResponseAuthentication> authenticate(@RequestBody @Valid RequestCredential request) {
		ResponseAuthentication response = new ResponseAuthentication();
		try {
			Authentication authenticate = authenticationManager.authenticate(request.getAuthentication());
			User user = (User) authenticate.getPrincipal();
			request.setUserId(user.getId());
			String token = tokenUtil.getToken(request);
			System.out.println(token);
			response.setToken(token)
			.setType("Bearer");
			
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(response);
		
		
	}
}
