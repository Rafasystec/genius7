package com.genius7.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.genius7.request.RequestCredential;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenUtil {
	
	@Value("${genius7.token.key}")
	private String secret;
	
	public String getToken(RequestCredential request) {
		
		return Jwts.builder()
				.setIssuer("genius7")
				.setSubject(request.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(null)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}

}
