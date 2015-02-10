package main.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Persons {
	
	@Id
	private String Id;
	
	@Column (name="first_name")
	private String firstName;
	
	@Column (name="sure_name")
	private String sureName;
	
	@Column (name="second_name")
	private String secondName;
	
	@Column (name="war_number")
	private String warNumber;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getWarBumber() {
		return warNumber;
	}

	public void setWarBumber(String warBumber) {
		this.warNumber = warBumber;
	}
	

}
