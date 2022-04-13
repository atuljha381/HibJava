package com.hib;

public class PersonMain {

	public static void main(String[] args) {
		PersonDAOImpl dao=new PersonDAOImpl();

		//dao.deletePerson(102);
		
		dao.addPerson(new Person(103,"meenu","clerk"));

		java.util.List<Person> list=dao.getAllRecords();
		list.forEach(p->System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPjob()));

		dao.getPerson(103);
		dao.updatePerson(103, "manager");
		
	}

}
