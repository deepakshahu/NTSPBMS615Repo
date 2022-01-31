package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nit.service.IEmployeeMgmtService;

@SpringBootApplication
public class JdbcProj04JdbcTemplateDirectMethodsBootApplication {

	public static void main(String[] args) {
		
		//Get IOC Container
		ApplicationContext ctx = SpringApplication.run(JdbcProj04JdbcTemplateDirectMethodsBootApplication.class, args);
		
		//Get Service class object
		IEmployeeMgmtService service = ctx.getBean("empService",IEmployeeMgmtService.class);
		
		//Invoke the method
		try {
			System.out.println("Emps count :: "+service.fetchEmpsCount());
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
		((ConfigurableApplicationContext) ctx).close();
		
	}//main
}//class