package com.example.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StatesDemo {
	
	// Practical of Hibernate Object States: Transient, Persistent, Detached, Removed
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
		//Creating Student object
		Student student = new Student();
		student.setId(1414);
		student.setName("John");
		student.setCity("Noida");
		student.setCertificate(new Certificate("Java Hibernate Course", "2 Month")); // Transient state
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student); // Persistent state: session, database
		student.setName("Pyare"); // Updated name will go in database because session and database are both in sync
		
		
		tx.commit();
		factory.close();
	}

}
