package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nit.beans.VotingEligibilityCheck;

public class BeanLifeCycleTest {

	public static void main(String[] args) {

		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Spring bean class object
		VotingEligibilityCheck voting = ctx.getBean("voting",VotingEligibilityCheck.class);

		//Invoke the business method
		System.out.println(voting.checkVotingCriteria());

		//Close container
		ctx.close();
	}//main
}//class