package com.nit.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import com.nit.model.Student;
import com.nit.service.IStudentMgmtService;

public class JdbcTemplateCallbackInterfacesTest {

	public static void main(String[] args) {
		
		//Create IOC Container
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/nit/cfgs/applicationContext.xml");

		//Get Service class object
		IStudentMgmtService service = ctx.getBean("studService",IStudentMgmtService.class);

		//invoke the method
		try {
			//System.out.println("101 record :: "+service.fetchStudentByNo(101));
			Student stud = service.fetchStudentByNo(100);
			System.out.println(stud);
		}
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException)
				System.err.println("Record not found");
			else if(dae instanceof BadSqlGrammarException)
				System.err.println("SQL query is wrong");
			else
				System.out.println("Other Internal Problems");
			dae.printStackTrace();
		}

		System.out.println("=======================================");
		List<Student> listStud = null;
		//invoke the method
		try {
			System.out.println("Student belonging to Pune, Mumbai, Noida are as follows: ");
			listStud = service.fetchStudentByCities("Pune", "Mumbai", "Noida");
			listStud.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException)
				System.err.println("Record not found");
			else if(dae instanceof BadSqlGrammarException)
				System.err.println("SQL query is wrong");
			else
				System.out.println("Other Internal Problems");
			dae.printStackTrace();
		}

		System.out.println("=======================================");
		//invoke the method
		try {
			System.out.println("Student belonging to Pune, Mumbai, Noida are as follows: ");
			listStud = service.fetchStudentByCities1("Pune", "Mumbai", "Noida");
			listStud.forEach(System.out::println);
		}
		catch(DataAccessException dae) {
			if(dae instanceof EmptyResultDataAccessException)
				System.err.println("Record not found");
			else if(dae instanceof BadSqlGrammarException)
				System.err.println("SQL query is wrong");
			else
				System.out.println("Other Internal Problems");
			dae.printStackTrace();
		}
		
		//Close container
		ctx.close();
	}//main
}//class