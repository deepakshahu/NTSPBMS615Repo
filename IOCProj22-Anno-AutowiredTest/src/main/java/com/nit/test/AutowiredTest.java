package com.nit.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.beans.WishMessageGenerator;

public class AutowiredTest {

	public static void main(String[] args) {

		// Create IOC container(BeanFactory Container)
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Target Spring bean class object
		WishMessageGenerator generator = ctx.getBean("com.nit.beans.WishMessageGenerator#0",WishMessageGenerator.class);
		WishMessageGenerator generator1 = ctx.getBean("com.nit.beans.WishMessageGenerator#1",WishMessageGenerator.class);
		System.out.println(generator.hashCode()+" "+generator1.hashCode());
		//Invoke B method
		String result = generator.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);
		
		System.out.println("Spring beans count :: "+ctx.getBeanDefinitionCount());
		System.out.println("Bean ids :: "+Arrays.toString(ctx.getBeanDefinitionNames()));
		// Close the IOC container
		ctx.close();
	}// main
}// class