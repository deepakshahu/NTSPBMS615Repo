package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.Customer;
import com.nit.beans.Employee1;
import com.nit.beans.Student;

public class SetterVsConstructorInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");

		//Get Spring bean class object
		Employee1 emp1 = factory.getBean("emp1",Employee1.class);
		System.out.println(emp1);
		System.out.println("-------------------");
		Student st1 = factory.getBean("stud1",Student.class);
		System.out.println(st1);		
		System.out.println("-------------------");
		Customer ct1 = factory.getBean("cust1",Customer.class);
		System.out.println(ct1);
	}

}
