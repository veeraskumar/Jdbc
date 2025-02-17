package com.rvk.project.FetchType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Aadhar.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session sc = sf.openSession();
		Transaction tran = sc.beginTransaction();

		Person s = sc.get(Person.class, 100);
		System.out.println(s);
		Aadhar a = s.getAadhar();
		System.out.println(a);

		tran.commit();
		sc.close();
		sf.close();
	}
}
