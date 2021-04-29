package com.example.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		//get , load
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		
		//get-student:102
//		Student student = (Student)session.get(Student.class, 102);  //in case the object is not found it returns null
		
		//load-student:102
		Student student = (Student)session.load(Student.class, 102); // in case the object is not found it return ObjectNotFoundException

		System.out.println(student);
		
		Address address = (Address)session.get(Address.class, 1);
		
		System.out.println(address);
		
		session.close();
		factory.close();
		
	}
}
