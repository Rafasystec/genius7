package com.genius7.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.genius7.enums.EnumTypeUser;

public class RequestUser extends SuperRequest{
	

	@NotNull
	private Long id;
	@NotBlank @Length(max=180)
	private String email;
	@NotBlank @Length(max=20)
	private String pwd;
	@NotNull
	private EnumTypeUser type;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	public void setType(EnumTypeUser type) {
		this.type = type;
	}

}
