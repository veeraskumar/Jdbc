package com.rvk.project.Hibernate.ProductDB;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
	Scanner scanner = new Scanner(System.in);
	Configuration cfg = new Configuration().addAnnotatedClass(Product.class).configure();
	SessionFactory sf = cfg.buildSessionFactory();
	Session sc = sf.openSession();
	Transaction tran = sc.beginTransaction();

	public void addProduct() {
		Product p = new Product();
		System.out.print("Enter The Id : ");
		p.setProductId(scanner.nextInt());
		System.out.print("Enter The Name of Product : ");
		p.setProductName(scanner.next());
		System.out.print("Enter The Brand odf produc : ");
		p.setProductBrand(scanner.next());
		System.out.print("Enter The Price of Product : ");
		p.setProductPrice(scanner.nextInt());
		sc.save(p);
		tran.commit();
		sf.close();
		sc.close();
		scanner.close();
	}

	public void findProduct() {
		System.out.println("Enter Id to Find Deatils : ");
		Product pd = sc.get(Product.class, scanner.nextInt());
		if (pd == null) {
			System.out.println("IS not Found!");
		} else {
			System.out.println(pd.toString());
		}
		tran.commit();
		sf.close();
		sc.close();
		scanner.close();
	}

	public void updateProductPriceById() {
		System.out.println("Enter Id to Update the Price : ");
		Product pd = sc.get(Product.class, scanner.nextInt());
		pd.setProductPrice(pd.getProductPrice() + scanner.nextInt());
		sc.update(pd);
		tran.commit();
		sf.close();
		sc.close();
		scanner.close();
	}

	public void deleteProductById() {
		System.out.println("Enter Id to Delete the Data : ");
		Product pd = sc.get(Product.class, scanner.nextInt());
		sc.delete(pd);
		tran.commit();
		sf.close();
		sc.close();
		scanner.close();
	}
}
