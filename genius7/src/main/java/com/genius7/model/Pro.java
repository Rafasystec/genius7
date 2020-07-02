package com.genius7.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="PRO")
public class Pro extends SuperEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2439403958852579735L;
	@Embedded
	private Person person;
	@Column(name="ABOUT",length=500)
	private String about;
	@JoinColumn(name=ID_USER, referencedColumnName=ID)
	@OneToOne
	private User user;
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "PRO_AND_AREAS", 
        joinColumns = { @JoinColumn(name = ID_PRO) }, 
        inverseJoinColumns = { @JoinColumn(name = ProArea.FK_AREA_PRO) }
    )
	private List<ProArea> areas;
	
	public User getUser() {
		return user;
	}
	public Pro setUser(User user) {
		this.user = user;
		return this;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public Pro setPerson(Person person) {
		this.person = person;
		return this;
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
	public Pro setAbout(String about) {
		this.about = about;
		return this;
	}
	/**
	 * @return the areas
	 */
	public List<ProArea> getAreas() {
		return areas;
	}
	/**
	 * @param areas the areas to set
	 */
	public void setAreas(List<ProArea> areas) {
		this.areas = areas;
	}
	
	
}
