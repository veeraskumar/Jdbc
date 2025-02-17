package com.rvk.project.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Company com = new Company();
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();

		com.setCompanyId(101);
		com.setCompanyName("Apple");

		emp1.setEmployeeId(1023);
		emp1.setEmployeeName("Xyz");
		emp1.setSalary(1_000_000);

		emp2.setEmployeeId(1025);
		emp2.setEmployeeName("Abc");
		emp2.setSalary(1_345_000);

		List<Employee> lst = new ArrayList<Employee>();
		lst.add(emp1);
		lst.add(emp2);
		com.setEmployee(lst);

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
