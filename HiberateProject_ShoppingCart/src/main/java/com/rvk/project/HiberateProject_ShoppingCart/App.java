package com.rvk.project.HiberateProject_ShoppingCart;

import com.rvk.project.HiberateProject_ShoppingCart.Dao.ShoppingCartDao;

public class App {
	public static void main(String[] args) {
		ShoppingCartDao scd = new ShoppingCartDao();
		scd.addProduct();
	}
}
