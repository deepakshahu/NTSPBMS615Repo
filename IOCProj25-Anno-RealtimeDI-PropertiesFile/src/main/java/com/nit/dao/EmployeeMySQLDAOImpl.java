package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.bo.EmployeeBO;

@Repository("mysqlEmpDAO")
public final class EmployeeMySQLDAOImpl implements IEmployeeDAO {
	private static final String REALTIMEDI_EMPLOYEE_INSERT_QUERY="INSERT INTO REALTIMEDI_SPRING_EMPLOYEE(ENAME,DESG,BASICSALARY,GROSSSALARY,NETSALARY) VALUES(?,?,?,?,?)";
	//HAS-A property
	@Autowired
	private DataSource ds;

	@Override
	public int insertEmployee(EmployeeBO bo) throws Exception {
		System.out.println("EmployeeMySQLDAOImpl.insertEmployee()");
		int result = 0;

		//Get Pooled JDBC Connection object and create PreparedStatement object
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(REALTIMEDI_EMPLOYEE_INSERT_QUERY)){
			//Set query parameter values
			ps.setString(1, bo.getEname());
			ps.setString(2, bo.getDesg());
			ps.setFloat(3, bo.getBasicSalary());
			ps.setFloat(4, bo.getGrossSalary());
			ps.setFloat(5, bo.getNetSalary());

			//Execute the query
			result = ps.executeUpdate();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se; //Exception re-throwing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; //Exception re-throwing
		}
		return result;
	}//method
}//class