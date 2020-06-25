package com.genius7.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class RequestCredential {
	
	private Long userId;
	private String email;
	private String pwd;
	public String getEmail() {
		return email;
	}
	public RequestCredential setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPwd() {
		return pwd;
	}
	public RequestCredential setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}
	
	public UsernamePasswordAuthenticationToken getAuthentication() {
		return new UsernamePasswordAuthenticationToken(email, pwd);
	}
	public Long getUserId() {
		return userId;
	}
	public RequestCredential setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	
	

}
