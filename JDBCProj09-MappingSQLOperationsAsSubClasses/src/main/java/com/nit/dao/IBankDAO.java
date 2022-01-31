package com.nit.dao;

import java.util.List;

import com.nit.model.BankAccount;

public interface IBankDAO {
	public List<BankAccount> getBankAccountsByBalanceRange(float start, float end);
	public BankAccount getBankAccountByAcno(long acno);
	public int updateBankAccountWithBonusByBalance(float bonus, float maxBalance);
}
