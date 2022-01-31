package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.model.BankAccount;
import com.nit.service.IBankAccountMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {

		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get service class object
		IBankAccountMgmtService service = ctx.getBean("bankService", IBankAccountMgmtService.class);

		//Invoke the method
		try {
			BankAccount bank = new BankAccount(9867741L, "Dhruval", 75000.0f, "Active");
			System.out.println(service.openAccount(bank));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//Close container
		ctx.close();
	}//main
}//class