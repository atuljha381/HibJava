package com.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PersonHandler {
	private static SessionFactory factory;
	public static SessionFactory getFactory() {
		factory = new Configuration().configure().buildSessionFactory();
		return factory;
	}
		
	public static void main(String[] args) throws Exception{
		addPerson(new Person(107,"Gaurav","ECE"));
		System.out.println("Completed");
	}
	
	public static void addPerson(Person person) throws Exception{
		factory = getFactory();
		Session session = factory.openSession();
		Transaction trans = session.getTransaction();
		try {
			trans.begin();
			session.persist(person);
			trans.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			if (trans!=null) {
				trans.rollback();
				System.out.println("Transaction Rollback");
			}
			e.printStackTrace();
		}
		finally {
			factory.close();
			System.out.println("Application Ended");
		}
	}

}
