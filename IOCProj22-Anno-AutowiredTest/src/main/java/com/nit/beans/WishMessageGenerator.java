//WishMessageGenerator.java
package com.nit.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class WishMessageGenerator {
	
	//HAS-A Property(supporting composition)
	@Autowired
	@Qualifier("dt")
	private Date date;
	
	@Autowired
	public WishMessageGenerator(@Qualifier("dt1") Date date) {
		this.date=date;
		System.out.println("WishMessageGenerator :: 0-param constructor :: Date :: "+date);
	}
	
	@Autowired
	@Qualifier("dt2")
	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate()");
		this.date=date;
	}
	
	@Autowired
	@Qualifier("dt3")
	public void assign(Date date) { //This method signature must match with setter method signature
		System.out.println("WishMessageGenerator.assign()");
		this.date=date;
	}
	
	//Business Method
	public String generateMessage(String user) {
		
		System.out.println("WishMessageGenerator.generateMessage() :: Date :: "+date);
		
		//get current hour of the day
		int hour = date.getHours();  //24-hours format(0 to 23)
		
		//generate wish message
		if(hour<12)
			return "Good Morning : " +user;
		else if(hour<16)
			return "Good Afternoon : "+user;
		else if(hour<20)
			return "Good Evening : "+user;
		else
			return "Good Night : "+user;
	}//method
}//class
