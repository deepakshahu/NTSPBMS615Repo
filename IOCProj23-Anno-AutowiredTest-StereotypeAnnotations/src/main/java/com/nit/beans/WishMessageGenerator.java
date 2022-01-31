//WishMessageGenerator.java
package com.nit.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wmg")
//@Scope("singleton")
@Lazy(true)
public class WishMessageGenerator {
	
	//HAS-A Property(supporting composition)
	@Autowired
	private Date date;
	
	public WishMessageGenerator(Date date) {
		System.out.println("WishMessageGenerator :: 0-param constructor");
		this.date = date;
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