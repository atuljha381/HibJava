package com.hib;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDAOImpl implements IPersonDAO {
	private static SessionFactory factory;
	
	public PersonDAOImpl() {
		factory=HibernateSessionFactory.getFactory();
	}
	@Override
	public void addPerson(Person person) {
		
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

	@Override
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> getAllRecords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePerson(int id, String job) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePerson(int id) {
		// TODO Auto-generated method stub

	}

}