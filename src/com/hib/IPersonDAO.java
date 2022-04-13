package com.hib;

public interface IPersonDAO {
void addPerson(Person person);
	Person getPerson(int id);
	java.util.List<Person> getAllRecords();
	void updatePerson(int id,String job);
	void deletePerson(int id);
}