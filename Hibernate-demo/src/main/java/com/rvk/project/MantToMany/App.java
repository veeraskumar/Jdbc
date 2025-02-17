package com.rvk.project.MantToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		Customer ctm1 = new Customer();
		Customer ctm2 = new Customer();
		Product pd1 = new Product();
		Product pd2 = new Product();

		ctm1.setCudtomerId(101);
		ctm1.setCustomerName("Xyz");

		ctm2.setCudtomerId(102);
		ctm2.setCustomerName("Abc");

		pd1.setProductId(11);
		pd1.setProductName("Glass");
		pd1.setProductPrice(1200);

		pd2.setProductId(34);
		pd2.setProductName("Mobile Case");
		pd2.setProductPrice(150);

		// Create List
		List<Product> plist1 = new ArrayList<Product>();
		plist1.add(pd1);
		plist1.add(pd2);
		ctm1.setProduct(plist1);

		List<Product> plist2 = new ArrayList<Product>();
		plist2.add(pd2);
		ctm2.setProduct(plist2);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Product.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session sc = sf.openSession();
		Transaction tran = sc.beginTransaction();

		sc.save(ctm1);
		sc.save(ctm2);
		sc.save(pd1);
		sc.save(pd2);

		tran.commit();
		sc.close();
		sf.close();
	}
}
