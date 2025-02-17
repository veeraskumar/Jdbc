package com.rvk.project.MantToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {
	@Id
	private int productId;
	private String productName;
	private int productPrice;

	@ManyToMany(mappedBy = "product")
	private List<Customer> cList;

	public List<Customer> getcList() {
		return cList;
	}

	public void setcList(List<Customer> cList) {
		this.cList = cList;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}
