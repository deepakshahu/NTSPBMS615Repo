package com.nit.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nit.beans.VotingEligibilityCheck;

public class BeanLifeCycleTest1 {

	public static void main(String[] args) {

		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nit/cfgs/applicationContext.xml");

		//Get Spring bean class object
		VotingEligibilityCheck voting = factory.getBean("voting",VotingEligibilityCheck.class);

		//Invoke the business method
		System.out.println(voting.checkVotingCriteria());

		//Destroy singletons
		factory.destroySingletons();
	}//main
}//class