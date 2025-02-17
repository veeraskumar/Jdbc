package com.rvk.project.actor_movies.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	private int actorId;
	private String actorName;
	private int age;
	private int salary;
	private String industry;
	private String natinality;

	@ManyToMany(mappedBy = "actor")
	private List<Movie> movie;

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getNatinality() {
		return natinality;
	}

	public void setNatinality(String natinality) {
		this.natinality = natinality;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", actorName=" + actorName + ", age=" + age + ", salary=" + salary
				+ ", industry=" + industry + ", natinality=" + natinality + ", movie=" + movie + "]";
	}

}
