package com.example.Mapping.OneToOne;

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

        ques1.setAnswer(ans1);

        //creating question
        Question ques2 = new Question();
        ques2.setQuestionId(1213);
        ques2.setQuestion("What is Python?");

        //creating answer
        Answer ans2 = new Answer();
        ans2.setAnswerId(344);
        ans2.setAnswer("Python is a programming language");
        ans2.setQuestion(ques2);

        ques2.setAnswer(ans2);

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        //  save
        session.save(ques1);
        session.save(ques2);
        session.save(ans1);
        session.save(ans2);

        transaction.commit();

        //fetching

        Question newQues = (Question)session.get(Question.class, 1212);
        System.out.println(newQues.getQuestion());
        System.out.println(newQues.getAnswer().getAnswer());


        session.close();
        factory.close();
    }

}
