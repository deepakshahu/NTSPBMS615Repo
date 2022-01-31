package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.beans.WishMessageGenerator;

public class AutowiredTest {

	public static void main(String[] args) {

		// Create IOC container(BeanFactory Container)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Target Spring bean class object
		WishMessageGenerator generator = ctx.getBean("wmg",WishMessageGenerator.class);
		
		//Invoke B method
		String result = generator.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);

		// Close the IOC container
		ctx.close();
	}// main
}// class