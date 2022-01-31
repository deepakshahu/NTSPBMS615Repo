package com.nit.test;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.service.BankService;

public class MethodReplacerTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Get Target class object/Proxy class object
		BankService service = ctx.getBean("bankService",BankService.class);
		System.out.println(service.getClass()+" "+service.getClass().getSuperclass()+" "+Arrays.toString(service.getClass().getDeclaredMethods()));
		
		//Invoke the business method
		System.out.println("Interest Amount :: "+service.calcInterestAmount(100000, 2, 12));
		
		//CLose container
		ctx.close();
	}//main
}//class