package com.nit.service;

import java.util.List;

import com.nit.model.BankAccount;

public interface IBankMgmtService {
	public List<BankAccount> fetchBankAccountsBySalRange(float start, float end);
	public BankAccount fetchBankAccountByAcno(long acno);
	public String addBonusToAccountsByBalance(float bonus, float maxBalance);
}
