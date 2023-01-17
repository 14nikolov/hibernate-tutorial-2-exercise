package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteTableEntries {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Computer.class).
				addAnnotatedClass(CPU.class).
				buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();

		try {
			// Retrieving Object/Row from Table by ID
			Computer computer = session.get(Computer.class, 16);
			// Deleting that Object/Row from Table 
			// This will also deleted the User Table Object/Row
			// that is linked to this ROW via FOREIGN KEY
			session.delete(computer);
		session.getTransaction().commit();
		
		}catch(Exception e) {
			System.out.println("\n\n\nFailed to delete table rows!");
			System.out.println("POSSIBLE CAUSE: Table row with given ID not found ");
			System.out.println("Closing session.\\n\\n\\n");
			session.close();
			e.printStackTrace();
		}
	}
	
}
