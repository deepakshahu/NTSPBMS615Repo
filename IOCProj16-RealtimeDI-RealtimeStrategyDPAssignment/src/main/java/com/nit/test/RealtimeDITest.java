package com.nit.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.controller.MainController;
import com.nit.vo.CustomerVO;

public class RealtimeDITest {
	public static void main(String[] args) {
		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");
		
		//Get Spring Bean class object ref
		MainController controller = factory.getBean("controller",MainController.class);
		
		//Read inputs as String values and store them into CustomerVO class object
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Customer Name: ");
		String name = sc.next();
		System.out.println("Enter Customer Address: ");
		String addrs = sc.next();
		System.out.println("Enter Customer Principle Amount: ");
		String pAmt = sc.next();
		System.out.println("Enter Customer Rate of Interest: ");
		String rate = sc.next();
		System.out.println("Enter Time(in Months): ");
		String time = sc.next();
		
		CustomerVO vo = new CustomerVO();
		vo.setCustName(name);
		vo.setCustAddress(addrs);
		vo.setPamt(pAmt);
		vo.setRate(rate);
		vo.setTime(time);
		
		//Invoke the bussiness method
		try {
			String result = controller.processCustomer(vo);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--Try Again :: "+e.getMessage());
		}
	}
}//class
