package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nit.bo.CustomerBO;

public class CustomerMySQLDAOImpl implements ICustomerDAO {
	private static final String CUST_INSERT_QUERY = "INSERT INTO REALTIMEDI_SPRING_CUSTOMER VALUES(?,?,?,?,?,?)";

	//HAS-A property
	private DataSource ds;

	//Alt+Shift+S,O
	public CustomerMySQLDAOImpl(DataSource ds) {
		System.out.println("CustomerMySQLDAOImpl :: 1-param constructor");
		this.ds = ds;
	}

	@Override
	public int insertCustomer(CustomerBO bo) throws Exception {
		System.out.println("CustomerMySQLDAOImpl.insertCustomer()");
		int result = 0;
		
		//Get Pooled JDBC Connection object and create PreparedStatement object
		try(Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(CUST_INSERT_QUERY);	){
			//Set values to query params
			ps.setString(1, bo.getCustName());
			ps.setString(2, bo.getCustAddress());
			ps.setFloat(3, bo.getPamt());
			ps.setFloat(4, bo.getRate());
			ps.setFloat(5, bo.getTime());
			ps.setFloat(6, bo.getInterestAmount());
			
			//Execute the query
			result = ps.executeUpdate();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //Exception re-throwing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;  //Exception re-throwing
		}
		return result;
	}//method
}//class