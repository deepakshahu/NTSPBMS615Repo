package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.comp.Flipkart;

public class StrategyDPTest {
	public static void main(String[] args) {
		
		//Create IOC container
		/*DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");*/
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/java/com/nit/cfgs/applicationContext.xml");
		
		//Get Target class object
		Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
		
		//Invoke the Business method
		String resultMsg = fpkt.shopping(new String[] {"shirt","trouser","glasses"}, new float[] {4500.0f,5858.5f,6451.0f});
		System.out.println(resultMsg);
		
		//Close container
		ctx.close();
	}//main
}//class
