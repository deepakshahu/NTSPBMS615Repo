package com.nit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IBankAccountDAO;
import com.nit.model.BankAccount;

@Service("bankService")
public class BankAccountMgmtServiceImpl implements IBankAccountMgmtService {
	
	@Autowired
	private IBankAccountDAO dao;

	@Override
	public String openAccount(BankAccount bank) {
		//Use DAO
		int count = dao.register(bank);
		return count==1?"BankAccount Opened":"Bank Account not opened";
	}//method
}//class
