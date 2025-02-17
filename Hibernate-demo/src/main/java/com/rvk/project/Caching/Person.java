package com.rvk.project.Caching;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Person {
	@Id
	private int personiD;
	private String personName;

	public int getPersoniD() {
		return personiD;
	}

	public void setPersoniD(int personiD) {
		this.personiD = personiD;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

}
