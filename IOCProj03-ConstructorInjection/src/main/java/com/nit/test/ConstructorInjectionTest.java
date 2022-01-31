package com.nit.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nit.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {

		//Hold spring bean configuration file name and location
		//FileSystemResource res = new FileSystemResource("src/main/java/com/nit/cfgs/applicationContext.xml");
		//FileSystemResource res = new FileSystemResource("E:\\Workspaces\\Spring\\NTSPBMS615\\IOCProj03-ConstructorInjection\\src\\main\\java\\com\\nit\\cfgs\\applicationContext.xml");
		ClassPathResource res = new ClassPathResource("com/nit/cfgs/applicationContext.xml");

		//Create IOC container(BeanFactory Container)
		XmlBeanFactory factory = new XmlBeanFactory(res);

		//Get Target Spring bean class object
		Object obj = factory.getBean("wmg");

		//Typecasting
		WishMessageGenerator generator = (WishMessageGenerator)obj;

		//Invoke B method
		String result = generator.generateMessage("Deepak");
		System.out.println("Wish Message is : "+result);
	}//main
}//class