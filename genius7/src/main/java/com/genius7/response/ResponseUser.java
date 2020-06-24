package com.genius7.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.genius7.enums.EnumTypeUser;
import com.genius7.model.User;

public class ResponseUser {

	public ResponseUser() {
		
	}
	
	public ResponseUser(List<User> users) {
		if(!users.isEmpty()) {
			users.forEach(user ->{
				getUsers().add(new ResponseUser()
						.setEmail(user.getEmail())
						.setId(user.getId()));
			});
		}
	}
	
	public static Page<ResponseUser> toList(Page<User> users){
		return users.map(ResponseUser::new);
	}
	
	public ResponseUser(User user) {
		this.email = user.getEmail();
		this.id = user.getId();
		this.type = user.getType();
		
	}

	private Long id;
	private String email;
	private EnumTypeUser type;
	@JsonIgnore
	private List<ResponseUser> users = new ArrayList<>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public ResponseUser setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public ResponseUser setEmail(String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return the users
	 */
	public List<ResponseUser> getUsers() {
		return users;
	}

	/**
	 * @return the type
	 */
	public EnumTypeUser getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public ResponseUser setType(EnumTypeUser type) {
		this.type = type;
		return this;
	}
	
	
}
