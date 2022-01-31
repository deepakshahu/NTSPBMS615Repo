package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.A;

public class CyclicDITest {
	
	public static void main(String[] args) {
		
		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
		
		//Get Spring bean class object
		A oa = factory.getBean("a1",A.class);
		System.out.println(oa);
	}
}
