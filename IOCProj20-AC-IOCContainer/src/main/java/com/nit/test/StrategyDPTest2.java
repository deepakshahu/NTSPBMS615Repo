package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.comp.Flipkart;

public class StrategyDPTest2 {
	public static void main(String[] args) {

		// Create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("applicationContext.xml");
		System.out.println("Bean Factory Container is created");

		//Get Target class object
		Flipkart fpkt = factory.getBean("fpkt",Flipkart.class);

		//Invoke the Business method
		String resultMsg = fpkt.shopping(new String[] {"shirt","trouser","glasses"}, new float[] {4500.0f,5858.5f,6451.0f});
		System.out.println(resultMsg);

	}// main
}// class
