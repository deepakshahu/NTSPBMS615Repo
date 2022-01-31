package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.comp.Vehicle;

public class StrategyDPTest {
	public static void main(String[] args) {
		
		//Create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
		
		//Get Target class object
		Vehicle vehicle = factory.getBean("vehicle",Vehicle.class);
		
		//Invoke the Business method
		String resultMsg = vehicle.journey(new String[] {"Chicken","Sandwich","Coke"});
		System.out.println(resultMsg);
	}//main
}//class
