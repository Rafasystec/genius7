package com.genius7.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class SuperEntity implements Serializable {

	public static final String ID_USER 	= "ID_USER";
	public static final String ID_CLI 	= "ID_CLI";
	public static final String ID_PRO 	= "ID_PRO";
	public static final String ID 		= "ID";
	/**
	 * 
	 */
	private static final long serialVersionUID = 8535860641291662663L;

	
	public SuperEntity(long id, Date register) {
		super();
		this.id = id;
		this.register = register;
	}
	public SuperEntity() {

	}

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private long id;
	@Column(name="REGISTER")
	@Temporal(TemporalType.TIMESTAMP)
	private Date register = new Date();


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperEntity other = (SuperEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
		
}
