package com.rvk.project.Hibernate.ProductDB;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		ProductDAO pdo = new ProductDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number for \n " + "1 = Add_Product,\n " + "2 = Find_Product,\n "
				+ "3 = Update_Product_Price,\n " + "4 = Delete Data Fom Db");
		switch (sc.nextInt()) {
		case 1:
			pdo.addProduct();
			break;
		case 2:
			pdo.findProduct();
			break;
		case 3:
			pdo.updateProductPriceById();
			break;
		case 4:
			pdo.deleteProductById();
			break;
		default:

			break;
		}
		sc.close();
	}
}
