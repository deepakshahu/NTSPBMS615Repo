package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.service.IBankMgmtService;

public class MappingSQLOperationsTest {

	public static void main(String[] args) {

		//Create IOC container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Service class object
		IBankMgmtService service = ctx.getBean("bankService", IBankMgmtService.class);

		//Invoke the method
		try {
			System.out.println("BankAccounts having balance range 70000 to 100000 are as follows :");
			service.fetchBankAccountsBySalRange(70000, 100000).forEach(System.out::println);
			System.out.println("==========================================================");
			System.out.println("BankAccounts having balance range 75000 to 85000 are as follows :");
			service.fetchBankAccountsBySalRange(75000, 85000).forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}

		System.out.println("=================================================================================");
		try {
			System.out.println("123458 BankAccount Details :: "+service.fetchBankAccountByAcno(123458));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}

		System.out.println("=================================================================================");
		try {
			System.out.println(service.addBonusToAccountsByBalance(1000, 10000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}

		//Close container
		ctx.close();
	}//main
}//class