package com.nit.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

//@Component("voting")
//@PropertySource("com/nit/commons/info.properties")
public class VotingEligibilityCheck implements InitializingBean, DisposableBean{

	//Spring bean properties
	//@Value("${per.name}")
	private String name;
	//@Value("${per.addrs}")
	private String addrs;
	//@Value("${per.age}")
	private int age;
	private Date verifiedOn;
	
	
	@PostConstruct
	public void custInit() {
		System.out.println("VotingEligibilityCheck.custInit()");
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

	@PreDestroy
	public void custDestroy() {
		System.out.println("VotingEligibilityCheck.custDestroy()");
		//Nullify bean property
		name = null;
		addrs = null;
		age = 0;
		verifiedOn = null;
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
	
	@Override
	public void destroy() throws Exception {
		System.out.println("VotingEligibilityCheck.destroy()");
		//Nullify bean property
		name = null;
		addrs = null;
		age = 0;
		verifiedOn = null;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("VotingEligibilityCheck.afterPropertiesSet()");
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
}//class