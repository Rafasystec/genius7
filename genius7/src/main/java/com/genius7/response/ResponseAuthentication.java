package com.genius7.response;

public class ResponseAuthentication {
	
	private Long userId;
	private String userName;
	private String token;
	private String type;
	public Long getUserId() {
		return userId;
	}
	public ResponseAuthentication setUserId(Long userId) {
		this.userId = userId;
		return this;
	}
	public String getUserName() {
		return userName;
	}
	public ResponseAuthentication setUserName(String userName) {
		this.userName = userName;
		return this;
	}
	public String getToken() {
		return token;
	}
	public ResponseAuthentication setToken(String token) {
		this.token = token;
		return this;
	}
	public String getType() {
		return type;
	}
	public ResponseAuthentication setType(String type) {
		this.type = type;
		return this;
	}
	
	

}
