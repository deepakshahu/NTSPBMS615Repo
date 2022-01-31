package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.service.ILoginMgmtService;

public class SimpleJdbcCallTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Get Service class object
		ILoginMgmtService service = ctx.getBean("loginService",ILoginMgmtService.class);
		
		//Invoke the method
		try {
			System.out.println(service.login("deepak", "deepak123"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//Close container
		ctx.close();
	}//main
}//class