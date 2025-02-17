package com.rvk.project.FetchType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int personId;
	private String personName;

	@OneToOne(fetch = FetchType.LAZY)
	/*
	 * Default is FetchType
	 * @OneToOne ----> EAGER
	 * @OneToMany ----> LAZY
	 * @ManyToOne ----> EAGER
	 * @ManyoMany----> LAZY
	 * */
	private Aadhar aadhar;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}
}
