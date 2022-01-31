package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.WishMessageGenerator;

public class SpringBeanScopesTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
		
		//Get Target Spring bean class object
		WishMessageGenerator generator1 = factory.getBean("wmg",WishMessageGenerator.class);
		WishMessageGenerator generator2 = factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println("hashcodes == "+generator1.hashCode()+" "+generator2.hashCode());
		System.out.println("generator1==generator2 ? "+(generator1==generator2));
		
		System.out.println("====================================");
		
		/*WishMessageGenerator generator3 = factory.getBean("wmg1",WishMessageGenerator.class);
		WishMessageGenerator generator4 = factory.getBean("wmg1",WishMessageGenerator.class);
		System.out.println("hashcodes == "+generator3.hashCode()+" "+generator4.hashCode());
		System.out.println("generator3==generator4 ? "+(generator3==generator4));*/
		
		//Invoke B method
		/*String result = generator1.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);*/
	}//main
}//class