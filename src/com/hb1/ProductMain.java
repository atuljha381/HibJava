package com.hb1;

import java.util.Scanner;

public class ProductMain {

	public static void main(String[] args) {
		ProductDAOImpl dao=new ProductDAOImpl();
		for(;;) {
		System.out.println("1.Add , 2.Get Product by id 3.Get All products 4.Update Product 5.Delete Product");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:
			dao.addProduct(new Product(5,"blue pen",10,100));
			break;
		case 2:
			System.out.println("enter id to be searched :");
			int id=sc.nextInt();
			System.out.println(dao.getProduct(id));
			break;
		case 3:
			java.util.List<Product> list=dao.getAllRecords();
			list.forEach(p->System.out.println(p));
			break;
		case 4:
			System.out.println("enter id :");
			 id=sc.nextInt();
			 System.out.println("enter quantity to be updated");
			 int qty=sc.nextInt();
			 dao.updateProduct(id, qty);
			break;
		case 5:
			System.out.println("enter id to be deleted :");
			id=sc.nextInt();
			dao.deleteProduct(id);
			break;
		default:
			System.out.println("Wrong choice Entered");
			
		}
	}
		
		//dao.deletePerson(102);
		
		

//		java.util.List<Person> list=dao.getAllRecords();
//		list.forEach(p->System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPjob()));

//		dao.getPerson(103);
//		dao.updatePerson(103, "manager");

	}

}
