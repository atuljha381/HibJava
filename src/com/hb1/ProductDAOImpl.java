package com.hb1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class ProductDAOImpl implements IProductDAO {
private static SessionFactory factory;
	
	public ProductDAOImpl() {
		factory=HibernateSessionFactory.getFactory();
	}
	
	@Override
	public void addProduct(Product prod) {
		Session session =factory.openSession();
		Transaction trans=session.getTransaction();
		try {
			trans.begin();
			session.persist(prod);
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
	public Product getProduct(int id) {
		Session session =factory.openSession();
		Product p=session.get(Product.class, id);
		return p;
	}

	@Override
	public List<Product> getAllRecords() {
		Session session =factory.openSession();
		java.util.List<Product> list=session.createQuery("from Product").list();
		return list;
	}

	@Override
	public void updateProduct(int id, int qty) {
		Session session=factory.openSession();
		Product p=getProduct(id);
		p.setQty(qty);
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
	public void deleteProduct(int id) {
		Session session=factory.openSession();
		Product p=getProduct(id);

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
			System.out.println("End of the task");
		}

	}

}
