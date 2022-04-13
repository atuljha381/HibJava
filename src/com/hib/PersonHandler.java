package com.hib;

import java.util.List;

import org.hibernate.Query;
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
	//-------------------------------------------------------------------------------------------------------
	public static Person getPerson(int id) {
		Person person = new Person();
		factory = getFactory();
		Session session = factory.openSession();
		person = session.get(Person.class, id);
		factory.close();
		return person;
	}
	//-------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws Exception{
//		addPerson(new Person(107,"Gaurav","ECE"));
//		System.out.println("Completed");
//		Person person = getPerson(102);
//		System.out.println(person);
		
		List<Person> list = getByJob("Clerk");
		list.forEach(e->System.out.println(e.getPid()+" "+e.getPname()+" "+e.getPjob()));
	}
	//-------------------------------------------------------------------------------------------------------
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
	//-------------------------------------------------------------------------------------------------------
	public static void updatePerson(int id,String job) {
		factory = getFactory();
		Session session = factory.openSession();
		Person person = getPerson(id);
		person.setPjob(job);
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.update(person);
			transaction.commit();
			System.out.println("record updated");
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
				System.out.println("Unable to update");
			}
			System.out.println(e);
		}
		finally {
			factory.close();
			System.out.println("End of the task");
		}
	}
	//-------------------------------------------------------------------------------------------------------
	public static void delete(int id) {
		factory = getFactory();
		Session session = factory.openSession();
		Person person = getPerson(id);
		Transaction transaction = session.getTransaction();
		try {
			transaction.begin();
			session.remove(person);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
				System.out.println("Unable to delete");
			}
			System.out.println(e);
		}
		finally {
			factory.close();
			System.out.println("End of task");
		}
				
		
	}
	//-------------------------------------------------------------------------------------------------------
	public static List<Person> getAllRecords(){
		factory = getFactory();
		Session session = factory.openSession();
		List<Person> list = session.createQuery("from Person").list();
		factory.close();
		return list;
	}
	//-------------------------------------------------------------------------------------------------------
		public static List<Person> getByJob(String job){
			factory = getFactory();
			Session session = factory.openSession();
			Query<Person> qry = session.createQuery("select p from Person p where pjob=:j").setParameter("j", job);
			List<Person> list = qry.list();
			factory.close();
			return list;
		}
	

}
