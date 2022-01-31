package com.nit.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.model.Employee;
import com.nit.service.IEmployeeMgmtService;

public class NamedParameterJdbcTemplateTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");
		
		//Get Service class object
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		
		//Invoke the method
		try {
			System.out.println("Employee Name :: "+service.fetchEmpNameByNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("===================================");
		//Invoke the method
		try {
			System.out.println("Employee Details by desg: CLERK, MANAGER, ANALYST are as follows: ");
			service.fetchEmpDetailsByDesgs("CLERK", "MANAGER", "ANALYST").forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("===================================");
		//Invoke the method
		try {
			Employee emp = new Employee(9090, "Suresh", "CLERK", 9000.0f);
			System.out.println(service.registerEmployee(emp));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		ctx.close();
	}//main
}//class