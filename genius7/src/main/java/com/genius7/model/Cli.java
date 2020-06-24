package com.genius7.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CLI")
public class Cli extends SuperEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6967985603946909714L;
	@Embedded
	private Person person;

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
}
