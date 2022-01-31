package com.nit.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nit.model.BankAccount;

@Repository("bankDAO")
public class BankAccountDAOImpl implements IBankAccountDAO {

	@Autowired
	private SimpleJdbcInsert sji;

	/*@Override
	public int register(BankAccount bank) {
		//Set DB table name
		sji.setTableName("BANK_ACCOUNT");
		//Prepare Map object having column names and values
		Map<String,Object> map = Map.of("acno", bank.getAcno(), "holderName", bank.getHolderName(), "balance", bank.getBalance(), "status", bank.getStatus());  //java9
		//Execute the query by generating the query dynamically
		int count = sji.execute(map);
		return count;
	}*/

	/*@Override
	public int register(BankAccount bank) {
		//Set DB table name
		sji.setTableName("BANK_ACCOUNT");
		//Use MapSqlParameterSource object having column names and values
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("ACNO", bank.getAcno());
		msps.addValue("HOLDERNAME", bank.getHolderName());
		msps.addValue("BALANCE", bank.getBalance());
		msps.addValue("STATUS", bank.getStatus());
		//Execute the query by generating the query dynamically
		int count = sji.execute(msps);
		return count;
	}*/

	@Override
	public int register(BankAccount bank) {
		//Set DB table name
		sji.setTableName("BANK_ACCOUNT");
		//Prepare BeanPropertySqlParameterSource object having Model class object(here column name must match with Model class property names)
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(bank);
		//Execute the query by generating the query dynamically
		int count = sji.execute(bpsps);
		return count;
	}
}