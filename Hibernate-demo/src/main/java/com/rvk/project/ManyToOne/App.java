package com.rvk.project.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Company com = new Company();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		com.setCompanyid(102);
		com.setCompanyName("KiA");

		emp1.setEmployeeId(1003);
		emp1.setEmployeeName("ert");
		emp1.setSalary(1_000_9999);
		emp1.setCom(com);

		emp2.setEmployeeId(1025);
		emp2.setEmployeeName("abc");
		emp2.setSalary(1345665);
		emp2.setCom(com);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class)
				.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session sc = sf.openSession();
		Transaction tran = sc.beginTransaction();

		sc.save(com);
		sc.save(emp1);
		sc.save(emp2);

		tran.commit();
		sc.close();
		sf.close();
	}
}
