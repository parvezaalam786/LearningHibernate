package com.example.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
       
        
        Student student1 = new Student();
        student1.setId(123);
        student1.setName("Parvez Ansari");
        student1.setCity("NOIDA");
        
        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Hibernate");
        certificate1.setDuration("1 week");
        student1.setCertificate(certificate1);
        
        Student student2 = new Student();
        student2.setId(124);
        student2.setName("Khurshed Ansari");
        student2.setCity("Gorakhpur");
        
        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Python");
        certificate2.setDuration("6 week");
        student2.setCertificate(certificate2);
        
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        //objects save
        session.save(student1);
        session.save(student2);

        
        transaction.commit();
        session.close();
        factory.close();
        
	}
}
