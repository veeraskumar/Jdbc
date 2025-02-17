package com.rvk.project.MantToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Customer {
	@Id
	private int cudtomerId;
	private String customerName;

	@ManyToMany
	private List<Product> product;

	public int getCudtomerId() {
		return cudtomerId;
	}

	public void setCudtomerId(int cudtomerId) {
		this.cudtomerId = cudtomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
