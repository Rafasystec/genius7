package com.genius7.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.genius7.enums.EnumTypeUser;

@Entity
@Table(name="USER_DB")
public class User extends SuperEntity{

	public static final User NOT_FOUND = new User();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4343903701540144059L;
	@Column(name="EMAIL",nullable=false,length=180)
	private String email = "";
	@Column(name="PWD",nullable=false,length=512)
	private String pwd = "";
	@Column(name="TYPE")
	@Enumerated(EnumType.ORDINAL)
	private EnumTypeUser type = EnumTypeUser.OTHER;
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public User setEmail(String email) {
		this.email = email;
		return this;
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
	public User setPwd(String pwd) {
		this.pwd = pwd;
		return this;
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
	public User setType(EnumTypeUser type) {
		this.type = type;
		return this;
	}
	
	
	
	
}
