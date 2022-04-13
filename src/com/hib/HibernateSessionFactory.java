package com.hib;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory factory;
	private HibernateSessionFactory() {}
	public static SessionFactory getFactory() {
		factory=new Configuration().configure().buildSessionFactory();
		return factory;
	}
	

}