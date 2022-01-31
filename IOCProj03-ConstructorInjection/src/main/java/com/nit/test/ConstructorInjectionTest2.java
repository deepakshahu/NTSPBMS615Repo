package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.WishMessageGenerator;

public class ConstructorInjectionTest2 {

	public static void main(String[] args) {
		
		//Create IOC container(BeanFactory Container)
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
		
		//Get Target Spring bean class object
		WishMessageGenerator generator = factory.getBean("wmg",WishMessageGenerator.class);

		//Invoke B method
		String result = generator.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);
	}//main
}//class