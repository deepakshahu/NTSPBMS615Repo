package com.nit.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nit.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		
		//Hold spring bean configuration file name and location
		FileSystemResource res = new FileSystemResource("src/main/java/com/nit/cfgs/applicationContext.xml");
		
		//Create IOC container(BeanFactory Container)
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		//Get Target Spring bean class object
		Object obj = factory.getBean("wmg");
		Object obj1 = factory.getBean("wmg");
		System.out.println(obj.hashCode()+" "+obj1.hashCode());
		
		//Typecasting
		WishMessageGenerator generator = (WishMessageGenerator)obj;
		
		//Invoke B method
		String result = generator.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);
	}//main
}//class