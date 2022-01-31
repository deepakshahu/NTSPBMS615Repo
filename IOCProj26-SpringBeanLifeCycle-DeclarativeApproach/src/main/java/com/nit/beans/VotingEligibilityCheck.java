package com.nit.beans;

import java.util.Date;

public class VotingEligibilityCheck {

	//Spring bean properties
	private String name;
	private String addrs;
	private int age;
	private Date verifiedOn;

	//Setter methods for setter injection
	public void setName(String name) {
		System.out.println("VotingEligibilityCheck.setName()");
		this.name = name;
	}
	public void setAddrs(String addrs) {
		System.out.println("VotingEligibilityCheck.setAddrs()");
		this.addrs = addrs;
	}
	public void setAge(int age) {
		System.out.println("VotingEligibilityCheck.setAge()");
		this.age = age;
	}

	//Custom init() method
	public void myInit() {
		System.out.println("VotingEligibilityCheck.myInit()");
		//Initialize left over properties
		verifiedOn = new Date();
		if(addrs == null) 
			addrs = "Address not provided";
		//Validation logic
		if(name==null)
			throw new IllegalArgumentException("Name is required");
		else if(age<=0 || age>=126)
			throw new IllegalArgumentException("Person age must be in the range of 1 through 125");
	}

	//Business Method
	public String checkVotingCriteria() {
		//Business logic
		if(age<18)
			return "Mr./Miss/Mrs."+name+" (age:"+age+") belongs to "+addrs+" is not eligible for voting --> verified on :: "+verifiedOn;
		else
			return "Mr./Miss/Mrs."+name+" (age:"+age+") belongs to "+addrs+" is eligible for voting --> verified on :: "+verifiedOn;
	}
	
	//Custom destroy() method
	public void myDestroy() {
		System.out.println("VotingEligibilityCheck.myDestroy()");
		//Nullify bean property
		name = null;
		addrs = null;
		age = 0;
		verifiedOn = null;
	}
}//class