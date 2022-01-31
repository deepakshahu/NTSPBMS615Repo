package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IBankDAO;
import com.nit.model.BankAccount;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {
	
	@Autowired
	private IBankDAO dao;
	
	@Override
	public List<BankAccount> fetchBankAccountsBySalRange(float start, float end) {
		//Use DAO
		return dao.getBankAccountsByBalanceRange(start, end);
	}//method

	@Override
	public BankAccount fetchBankAccountByAcno(long acno) {
		//Use DAO
		return dao.getBankAccountByAcno(acno);
	}//method

	@Override
	public String addBonusToAccountsByBalance(float bonus, float maxBalance) {
		//Use DAO
		int count = dao.updateBankAccountWithBonusByBalance(bonus, maxBalance);
		return count+" number of accounts are added with bonus "+bonus;
	}//method
	
}//class