package com.mypackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadAllTableRows {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Computer.class).
				addAnnotatedClass(CPU.class).
				buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		try {
			// Reading all table rows of table "computer" and storing them in a list
			List<Computer> computersList =  
					session.createQuery("from Computer", Computer.class).
					getResultList();

			// Printing in console all of the computers and their cpus
			for(Computer computer: computersList) {
				System.out.println("\n" + computer.toString());
				System.out.println(computer.getCpu().toString());
			}
			
			
		session.close();
		}catch(Exception e) {
			System.out.println("\n\n\nFailed to retrieve Rows from Tables");
			System.out.println("Closing session\n\n\n");
			session.close();
			e.printStackTrace();
		}
		
		
		
	}
	
}
