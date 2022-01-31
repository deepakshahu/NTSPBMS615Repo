package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.WishMessageGenerator;
import com.nit.ston.Printer;

public class SpringBeanScopesTest1 {

	public static void main(String[] args) {

		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");

		//Get Spring bean class object
		Printer p1 = factory.getBean("p1",Printer.class);
		Printer p2 = factory.getBean("p1",Printer.class);
		System.out.println(p1.hashCode()+" "+p2.hashCode());

		System.out.println("=========================");

		/*//Get Spring bean class object
		Printer p3 = factory.getBean("p",Printer.class);
		Printer p4 = factory.getBean("p",Printer.class);
		System.out.println(p3.hashCode()+" "+p4.hashCode());*/

	}//main
}//class