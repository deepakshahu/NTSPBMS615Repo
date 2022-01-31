package com.nit.beans;

public class Student {
	//let us assume optional to provide
	private String sname;
	private String collegeName;
	private String qlfy;
	private int age;
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public void setQlfy(String qlfy) {
		this.qlfy = qlfy;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", collegeName=" + collegeName + ", age=" + age + ", qlfy=" + qlfy + "]";
	}
}
