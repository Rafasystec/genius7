package com.genius7.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.genius7.enums.ProArea;

@Entity
@Table(name="PRO")
public class Pro extends SuperEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2439403958852579735L;
	@Embedded
	private Person person;
	@Column(name="AREA",length=4,nullable=false)
	@Enumerated(EnumType.ORDINAL)
	private ProArea area;
	@Column(name="ABOUT",length=500)
	private String about;
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
	/**
	 * @return the area
	 */
	public ProArea getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(ProArea area) {
		this.area = area;
	}
	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}
	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	
	
}
