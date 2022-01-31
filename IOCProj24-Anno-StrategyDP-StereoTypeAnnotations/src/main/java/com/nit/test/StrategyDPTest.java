package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.comp.DHL;
import com.nit.comp.Flipkart;
import com.nit.comp1.TestBean;

public class StrategyDPTest {
	public static void main(String[] args) {
		
		//Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Get Target class object
		Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
		
		//Invoke the Business method
		String resultMsg = fpkt.shopping(new String[] {"shirt","trouser","glasses"}, new float[] {4500.0f,5858.5f,6451.0f});
		System.out.println(resultMsg);
		System.out.println("=================");
		DHL dhl = ctx.getBean("dhl",DHL.class);
		System.out.println(dhl);
		System.out.println("=================");
		TestBean tb = ctx.getBean("tb",TestBean.class);
		System.out.println(tb);
		
		//Close IOC Container
		ctx.close();
	}//main
}//class
