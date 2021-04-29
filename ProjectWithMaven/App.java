package com.example.ProjectWithMaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 * Database used is "myhiber"
 * Port is 3308
 * username = root
 * password is blank
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started!!" );
        
        /**
         * SessionFactory is a type of connection, we will be able to save with its help.
         * */
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        // creating student
        Student student = new Student();
        student.setId(102);
        student.setName("PARVEZ");
        student.setCity("NOIDA");
        System.out.println(student);
        
        // creating object of address class
        Address address = new Address();
        address.setStreet("street1");
        address.setCity("DELHI");
        address.setOpen(true);
        address.setAddedDate(new Date());
        address.setX(1234.123);
        
        // Reading Image
//        FileInputStream fis = new FileInputStream("src/main/java/Parvez.jpg");
//        byte[] data = new byte[fis.available()];
//        fis.read(data);
//        address.setImage(data);
        
//        Session session = factory.getCurrentSession(); // when we have worked on the session previously
        Session session = factory.openSession(); // when first time making the session

        ///
        Transaction transaction = session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();
        ///
        System.out.println("Done!!");
    }
}
