package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateTableEntries {
	
	public static void main(String[] args) {
		
		// create a session factory and configure it
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Computer.class).
				addAnnotatedClass(CPU.class).
				buildSessionFactory();
		
		// create a session
		Session session = sessionFactory.getCurrentSession();
		
		// create a transaction
		session.beginTransaction();
		
		// Create a new Object/entry for table "computer"
		Computer computer = new Computer("MSI", "Aegis RS 11th Gen","gaming", 2499);
		// Create a new Object/entry for table "cpu"
		CPU cpu = new CPU("Intel", "i7-11700K");
		computer.setCpu(cpu);
		
		try {
		// do stuff in transaction (save, delete, createQuery() and etc)
		session.save(computer);

		
		// end transaction and commit changes to table
		session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("\n\n\nFailed to save Objects to Database");
			System.out.println("CLOSING session\n\n\n");
			session.close();
			e.printStackTrace();
		}
	}
	
}
