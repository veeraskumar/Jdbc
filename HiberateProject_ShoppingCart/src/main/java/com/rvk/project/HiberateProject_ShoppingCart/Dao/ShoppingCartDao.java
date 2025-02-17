package com.rvk.project.HiberateProject_ShoppingCart.Dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rvk.project.HiberateProject_ShoppingCart.Entity.Cart;
import com.rvk.project.HiberateProject_ShoppingCart.Entity.Product;
import com.rvk.project.HiberateProject_ShoppingCart.Entity.User;

public class ShoppingCartDao {
	Scanner scan = new Scanner(System.in);
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class).addAnnotatedClass(User.class)
			.addAnnotatedClass(Cart.class);
	SessionFactory sf = cfg.buildSessionFactory();
	Session sc = sf.openSession();
	Transaction tran = sc.beginTransaction();

	public void addProduct() {
		Product p = new Product();
		System.out.print("Enter ID for Product : ");
		p.setProductId(scan.nextInt());
		System.out.print("Enter Product Name : ");
		p.setProductName(scan.next());
		System.out.print("Enter Product Brand : ");
		p.setBrand(scan.next());
		System.out.print("Enter Product Price : ");
		p.setPrice(scan.nextInt());

		sc.save(p);

		tran.commit();
		sc.close();
		sf.close();
	}

	public void addUserWithCart() {
		User user = new User();
		user.setUserId(scan.nextInt());
		user.setUserName(scan.next());
		user.setEmail(scan.next());
		user.setMobile(scan.nextLong());
		user.setLocation(scan.next());

		Cart c = sc.get(Cart.class, scan.nextInt());
		if (c != null) {

			c.setCartId(c.getCartId());
			user.setCart(c);

			sc.save(c);
			sc.save(user);
		} else {
			System.out.println("The Product is Not Found! ");
		}

		tran.commit();
		sc.close();
		sf.close();
	}

	public void addProductFromUserCart() {
		Product pro = sc.get(Product.class, scan.nextInt());
		if (pro != null) {
			User user = sc.get(User.class, pro.getProductId());
			if (user != null) {
				Cart c = user.getCart();
				List<Product> plist = c.getProduct();
				plist.add(pro);
				sc.save(c);
			}
		} else {
			System.out.println("the No Record Founded!");
		}
		tran.commit();
		sc.close();
		sf.close();
	}
}
