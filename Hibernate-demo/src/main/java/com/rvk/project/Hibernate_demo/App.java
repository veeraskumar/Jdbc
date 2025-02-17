package com.rvk.project.Hibernate_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		/**
		 * Before that We need Create class from Give the detail of table like name
		 * with @Entry then it Find out. And with Class inside give the variable name.
		 * And Weather Create columns name with the primary key is Important the
		 * Variable private And we need Setter and getter methods for that.
		 */
		Configuration cfg = new Configuration(); // configuration SetUp
		cfg.configure(); // loading configure File
		cfg.addAnnotatedClass(Student.class); // loading class file
		SessionFactory sf = cfg.buildSessionFactory(); // loading configuration and build it
		Session sec = sf.openSession(); // open session to write update data it will write Query with given data
		Transaction tsn = sec.beginTransaction(); // to commit

		Student stud = new Student();
		stud.setStudentId(101);
		stud.setStudentAge(23);
		stud.setStudentMark(120);
		stud.setStudentName("xyz");
		stud.setStudentEmail("xyz@gmail.com");

		sec.save(stud);

		/** Fetch data from DataBase But We Can fetch only data from table */
		Student stud1 = sec.get(Student.class, 101);

		// Getting Data
		System.out.println(stud1.getStudentEmail());

		// update the Data from DB
//		std.setStudentAge(41);
//		sec.update(Stud);

		// Deleting the Data from DB
//		sec.delete(stud);

		tsn.commit();
		sec.close();
		sf.close();
	}
}
