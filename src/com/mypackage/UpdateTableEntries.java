package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateTableEntries {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Computer.class).
				addAnnotatedClass(CPU.class).
				buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
		// modify column "model" at row "15" in table "computer"
		Computer computer = session.get(Computer.class, 15);
		computer.setModel("Aegis RS3D Ryzen");
		// create a new row in table "cpu"
		// make row 15 from table "computer" point to it
		computer.setCpu(new CPU("AMD", "Ryzen 7 5800X3D"));
		
		session.save(computer);
		
		session.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("\n\n\nTransaction failed");
			System.out.println("Closing session\n\n\n");
			e.printStackTrace();
		}
	}
	
	
}
