package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.beans.Cricketer;

public class DependencyLookupTest {

	public static void main(String[] args) {
		
		//Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Get Target class object
		Cricketer player = ctx.getBean("cktr",Cricketer.class);
		
		//Invoke the business method
		player.batting();
		player.bowling();
		player.fielding();
		player.wicketKeeping();
		
		//close stream
		ctx.close();
	}//main
}//class