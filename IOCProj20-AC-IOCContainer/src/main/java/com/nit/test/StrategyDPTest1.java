package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.comp.Flipkart;

public class StrategyDPTest1 {
	public static void main(String[] args) {
		
		//Create IOC container		
		//FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/nit/cfgs/applicationContext.xml");
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Get Target class object
		Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
		
		//Invoke the Business method
		String resultMsg = fpkt.shopping(new String[] {"shirt","trouser","glasses"}, new float[] {4500.0f,5858.5f,6451.0f});
		System.out.println(resultMsg);
		
		//Close container
		ctx.close();
	}//main
}//class
