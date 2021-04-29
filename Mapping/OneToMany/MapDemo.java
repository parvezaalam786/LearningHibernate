package com.example.Mapping.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        //creating question
        Question ques1 = new Question();
        ques1.setQuestionId(1212);
        ques1.setQuestion("What is Java?");
        
        //creating answer
        Answer ans1 = new Answer();
        ans1.setAnswerId(343);
        ans1.setAnswer("Java is a programming language");
        ans1.setQuestion(ques1);
        
        Answer ans2 = new Answer();
        ans2.setAnswerId(344);
        ans2.setAnswer("With the help of Java we can create objects.");
        ans2.setQuestion(ques1);

        Answer ans3 = new Answer();
        ans3.setAnswerId(345);
        ans3.setAnswer("Java has different types of frameworks.");
        ans3.setQuestion(ques1);
        
        List<Answer> list = new ArrayList<Answer>();
        list.add(ans1);
        list.add(ans2);
        list.add(ans3);
        
        ques1.setAnswers(list);
        
        //session
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        
        //  save
        session.save(ques1);
        session.save(ans1);
        session.save(ans2);
        session.save(ans3);
        
        transaction.commit();
        
        //fetching data: finding all the answers of a question
        Question ques = (Question)session.get(Question.class, 1212);
        System.out.println(ques.getQuestion());
        
        for(Answer ans: ques.getAnswers()) {
        	System.out.println(ans.getAnswer());
        }
        
        session.close();
        factory.close();
	}
	
}
