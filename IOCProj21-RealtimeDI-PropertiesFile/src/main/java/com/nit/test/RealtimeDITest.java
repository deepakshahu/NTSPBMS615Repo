package com.nit.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.nit.controller.MainController;
import com.nit.vo.EmployeeVO;

public class RealtimeDITest {

	public static void main(String[] args) {

		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Controller class object
		MainController controller = ctx.getBean("controller", MainController.class);

		//Read inputs as String value and store them into EmployeeVO class object
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name: ");
		String name = sc.next();
		System.out.println("Enter Employee Desg: ");
		String desg = sc.nextLine();
		sc.nextLine();
		System.out.println("Enter Basic Salary: ");
		String basicSalary = sc.next();

		EmployeeVO vo = new EmployeeVO();
		vo.setEname(name);
		vo.setDesg(desg);
		vo.setBasicSalary(basicSalary);

		//Invoke the Business Method
		try {
			String msg = controller.processEmployee(vo);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problem in Employee Registration");
		}
		System.out.println("------------------------");
		System.out.println(System.getProperties());
		System.out.println("------------------------");
		Environment env = ctx.getEnvironment();
		System.out.println(env.toString());
		System.out.println(env.getRequiredProperty("os.name"));
		System.out.println(env.getClass());
	}//main
}//class