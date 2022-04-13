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
		Session session =factory.openSession();
		Transaction trans=session.getTransaction();
		try {
			trans.begin();
			session.persist(person);
			trans.commit();
			System.out.println("Record Inserted");
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
				System.out.println("Transaction rolledback");
			}
			e.printStackTrace();
		}
		finally {
			System.out.println("Application Ended");
		}

	}

	@Override
	public Person getPerson(int id) {
		Session session =factory.openSession();
		Person p=session.get(Person.class, id);
		return p;
	}

	@Override
	public List<Person> getAllRecords() {
		Session session =factory.openSession();
		java.util.List<Person> list=session.createQuery("from Person").list();
		return list;
	}

	@Override
	public void updatePerson(int id, String job) {
		Session session=factory.openSession();
		Person p=getPerson(id);
		p.setPjob(job);
		Transaction trans=session.getTransaction();
		try {
			trans.begin();
			session.update(p);
			trans.commit();
			System.out.println("Record Updated");
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
				System.out.println("Unable to Update");
			}
			e.printStackTrace();
		}
		finally {
			System.out.println("End of the task");
		}

	}

	@Override
	public void deletePerson(int id) {
		Session session=factory.openSession();
		Person p=getPerson(id);

		Transaction trans=session.getTransaction();
		try {
			trans.begin();
			session.remove(p);
			trans.commit();
			System.out.println("Record Deleted");
		} catch (Exception e) {
			if(trans!=null) {
				trans.rollback();
				System.out.println("Unable to Delete");
			}
			e.printStackTrace();
		}
		finally {
//			factory.close(); not to close object
			System.out.println("End of the task");
		}

	}

}
