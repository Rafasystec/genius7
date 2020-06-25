package com.genius7.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.genius7.request.RequestCredential;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenUtil {
	
	@Value("${genius7.token.key}")
	private String secret;
	
	public String getToken(RequestCredential request) {
		
		return Jwts.builder()
				.setIssuer("genius7")
				.setSubject(String.valueOf(request.getUserId()))
				.setIssuedAt(new Date())
				.setExpiration(null)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean isValid(String Token) {
		try {
			Jwts.parser().setSigningKey(this.secret).parseClaimsJws(Token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Long getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		return Long.parseLong(claims.getSubject());
		
	}

}
