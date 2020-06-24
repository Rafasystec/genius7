package com.genius7.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Person {

	@Column(name="CPF",nullable=true,length=14)
	private String cpf;
	@Column(name="NAME",nullable=false,length=180)
	private String name;
	@Column(name="BITH",nullable=true)
	@Temporal(TemporalType.DATE)
	private Date bith;
	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}
	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bith
	 */
	public Date getBith() {
		return bith;
	}
	/**
	 * @param bith the bith to set
	 */
	public void setBith(Date bith) {
		this.bith = bith;
	}
	
	
	
	
}
