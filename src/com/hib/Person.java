package com.hib;

public class Person {
	private int pid;
	private String pname;
	private String pjob;
	public Person() {}
	public Person(int pid, String pname, String pjob) {
		this.pid = pid;
		this.pname = pname;
		this.pjob = pjob;
	}
	public int getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public String getPjob() {
		return pjob;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPjob(String pjob) {
		this.pjob = pjob;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", pjob=" + pjob + "]";
	}
	
	
}