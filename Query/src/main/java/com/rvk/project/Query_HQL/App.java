package com.rvk.project.Query_HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Mobile.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tran = ss.beginTransaction();

//		Query<Mobile> query = ss.createQuery("FROM Mobile");
//		List<Mobile> listMobile = ss.createQuery("FROM Mobile").list();
//		for (Mobile mobile : listMobile) {
//			System.out.println(mobile.getMobileBrand());
//		}

		Query<Mobile> listMobile = ss
				.createQuery("UPDATE Mobile m SET m.price = ?1, m.year = ?2 where m.mobileId = ?3");
		listMobile.setParameter(2, 2024);
		listMobile.setParameter(1, 45999);
		listMobile.setParameter(3, 103);
		// ss.createQuery("DELETE Mobile WHERE m.mobile = 101");
		int rowUpdate = listMobile.executeUpdate();
		System.out.println(rowUpdate);

		tran.commit();
		ss.close();
		sf.close();
	}
}
