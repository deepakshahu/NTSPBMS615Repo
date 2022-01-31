package com.nit.beans;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer {
	
	//No HAS-A property of dependent class
	
	public Cricketer() {
		System.out.println("Cricketer :: 0-param constructor");
	}
	
	public void bowling() {
		System.out.println("Cricketer is bowling");
	}
	
	public void batting() {
		System.out.println("Cricketer is batting");
		
		//Create additional IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Perform dependency lookup method to get dependent class object
		Bat bat = ctx.getBean("bat",Bat.class);  //DL code
		int score = bat.scoreRuns();
		System.out.println("Cricketer batting score is : "+score);
		
		//close stream
		ctx.close();
	}
	
	public void fielding() {
		System.out.println("Cricketer is fielding");
	}
	
	public void wicketKeeping() {
		System.out.println("Cricketer is wicketKeeping");
	}
}//class