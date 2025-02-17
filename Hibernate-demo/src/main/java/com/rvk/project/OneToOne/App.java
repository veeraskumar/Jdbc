package com.rvk.project.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Person p = new Person();
		p.setPersonId(101);
		p.setPersonName("xyz");

		Aadhar aadhar = new Aadhar();
		aadhar.setAadharId(1);
		aadhar.setAadharNo(123456787654l);

		// Primary Key Connect to Set value
		p.setAadhar(aadhar);

		Configuration cfg = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Aadhar.class)
				.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session sc = sf.openSession();
		Transaction tran = sc.beginTransaction();

		sc.save(p);
		sc.save(aadhar);

		tran.commit();
		sc.close();
		sf.close();
		
	
		
		
	}
}
