//WishMessageGenerator.java
package com.nit.beans;

import java.util.Date;

public class WishMessageGenerator {
	
	//HAS-A Property(supporting composition)
	private Date date;
	
	//For construction injection(Alt+shift+s, o--select Date()-->ok)
	private WishMessageGenerator(Date dat) {
		System.out.println("WishMessageGenerator :: 1-param constructor");
		this.date=date;
	}
	
	public void setDate1(Date date) {
		System.out.println("WishMessageGenerator.setDate(-)");
		this.date = date;
	}

	//Business Method
	public String generateMessage(String user) {
		
		System.out.println("WishMessageGenerator.generateMessage()::"+date);
		
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
