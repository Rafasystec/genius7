package com.genius7.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRO_AREA")
public class ProArea extends SuperEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 172715006616250479L;
	public static final String FK_AREA_PRO 		= "ID_AREA";
	@Column(name="DESCRIPTION",nullable=false,length=100)
	private String description = "";
	@Column(name="COUNT",nullable=true)
	private Long count = 0L;
	@ManyToMany(mappedBy = "areas")
	private List<Pro> pros;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
	/**
	 * Is the amount of pro that this area have
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}
	/**
	 * @return the pros
	 */
	public List<Pro> getPros() {
		return pros;
	}
	/**
	 * @param pros the pros to set
	 */
	public void setPros(List<Pro> pros) {
		this.pros = pros;
	}
	
	

}
