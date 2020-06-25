package com.genius7.model;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Profile extends SuperEntity implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6051822645865028753L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}
	
	

}
