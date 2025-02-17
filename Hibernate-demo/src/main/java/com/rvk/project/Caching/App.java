package com.rvk.project.Caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session s1 = sf.openSession();
		Transaction t1 = s1.beginTransaction();
		Person p = s1.get(Person.class, 100);
		System.out.println(p);
		t1.commit();
		s1.close();

		Session s2 = sf.openSession();
		Transaction t2 = s2.beginTransaction();
		Person p2 = s2.get(Person.class, 100);
		System.out.println(p2 + "	" + p2.getPersoniD());
		t2.commit();
		s2.close();

		System.out.println();

		Session s3 = sf.openSession();
		Transaction t3 = s3.beginTransaction();
		Person p3 = s3.get(Person.class, 100);
		System.out.println(p3);
		t3.commit();
		s3.close();

		sf.close();
	}
}
