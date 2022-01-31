package com.nit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.config.AppConfig;
import com.nit.service.IEmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Get Service class object
		IEmployeeMgmtService service = ctx.getBean("empService", IEmployeeMgmtService.class);
		
		//Invoke the business method
		try {
			System.out.println("Employee Count :: "+service.fetchEmpsCount());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			System.out.println("Employee Name for given EmpNo : "+service.fetchEmpNameByEmpNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			System.out.println("Employee Details for 7499 eno are : "+service.fetchEmpDetailsByEmpNo(7499));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			//System.out.print("CLERK, MANAGER DESG Emp Details : "+service.fetchEmpDetailsByDesgs("CLERK", "MANAGER", "ANALYST"));
			/*service.fetchEmpDetailsByDesgs("CLERK", "MANAGER","ANALYST").forEach(map->{  //Java 8 forEach,Lambda expression
				System.out.println(map);
			});*/
			//service.fetchEmpDetailsByDesgs("CLERK", "MANAGER", "ANALYST").forEach(map->System.out.println(map));  //Java 8 forEach, Lambda expression improvised
			service.fetchEmpDetailsByDesgs("CLERK", "MANAGER", "ANALYST").forEach(System.out::println);  //Java 8 forEach, method reference
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			System.out.println(service.fireEmpsOnBench());
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			//System.out.println(service.depositBonusToEmpsByDesgs(1000, "SALESMAN", "CLERK"));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("-------------------------------");
		try {
			//System.out.println(service.registerEmployee("Amitabh", "Actor", 50000));
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//Close container
		ctx.close();
	}//main
}//class