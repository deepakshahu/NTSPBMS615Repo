package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nit.model.BankAccount;

@Repository("bankDAO")
public class BankDAOImpl implements IBankDAO {

	private static final String GET_BANK_ACCOUNTS_BY_SAL_RANGE = "SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT WHERE BALANCE>=? AND BALANCE<=?";
	private static final String GET_BANK_ACCOUNT_BY_ACNO = "SELECT ACNO,HOLDERNAME,BALANCE,STATUS FROM BANK_ACCOUNT WHERE ACNO=?";
	private static final String UPDATE_BONUS_BY_BALANCE = "UPDATE BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE BALANCE<?";
	
	BankAccountSelectorBySalRange selector1;
	BankAccountSelectorByAcno selector2;
	BankAccountUpdatorByBalance updator1;

	@Autowired	//Constructor injection , bcoz field level is not going to workout as ds is not ready
	public BankDAOImpl(DataSource ds) {
		System.out.println("BankDAOImpl :: 0-param constructor");
		selector1 = new BankAccountSelectorBySalRange(ds, GET_BANK_ACCOUNTS_BY_SAL_RANGE);
		selector2 = new BankAccountSelectorByAcno(ds, GET_BANK_ACCOUNT_BY_ACNO);
		updator1 = new BankAccountUpdatorByBalance(ds, UPDATE_BONUS_BY_BALANCE);
	}

	@Override
	public List<BankAccount> getBankAccountsByBalanceRange(float start, float end) {
		System.out.println("BankDAOImpl.getBankAccountsByBalanceRange()");
		List<BankAccount> list = selector1.execute(start,end);
		return list;
	}//method

	//Inner class cum sub class for SQL Query1
	private static class BankAccountSelectorBySalRange extends MappingSqlQuery<BankAccount>{

		public BankAccountSelectorBySalRange(DataSource ds, String query) {
			super(ds,query);  //gives DS, query to super class
			System.out.println("BankDAOImpl.BankAccountSelectorBySalRange :: 2-param constructor");
			//register query param(?) with jdbc type
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			//make super class to compile query
			super.compile();
		}

		@Override
		protected BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankDAOImpl.BankAccountSelectorBySalRange.mapRow()");
			//Convert RS record into BO class object
			BankAccount bank = new BankAccount();
			bank.setAcno(rs.getLong(1));
			bank.setHolderName(rs.getString(2));
			bank.setBalance(rs.getFloat(3));
			bank.setStatus(rs.getString(4));
			return bank;
		}//mapRow(-,-)

	}//inner class

	//=====================================================================================================

	@Override
	public BankAccount getBankAccountByAcno(long acno) {
		System.out.println("BankDAOImpl.getBankAccountByAcno()");
		BankAccount bank = selector2.findObject(acno);
		return bank;
	}//method

	//Inner class cum sub class2 for SQL Query2
	private static class BankAccountSelectorByAcno extends MappingSqlQuery<BankAccount>{
		
		public BankAccountSelectorByAcno(DataSource ds, String query) {
			super(ds,query);  //gives DS, query to super class
			System.out.println("BankDAOImpl.BankAccountSelectorByAcno.BankAccountSelectorByAcno()");
			//register query param(?) with jdbc type
			super.declareParameter(new SqlParameter(Types.INTEGER));
			//Make super class to compile query
			super.compile();
		}

		@Override
		protected BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("BankDAOImpl.BankAccountSelectorByAcno.mapRow()");
			//copy RS record into model class object
			BankAccount bank = new BankAccount();
			bank.setAcno(rs.getLong(1));
			bank.setHolderName(rs.getString(2));
			bank.setBalance(rs.getFloat(3));
			bank.setStatus(rs.getString(4));
			return bank;
		}//mapRow(-,-)

	}//inner class 2
	
	//=====================================================================================================

	@Override
	public int updateBankAccountWithBonusByBalance(float bonus, float maxBalance) {
		int count = updator1.update(bonus, maxBalance);
		return count;
	}//method
	
	//Inner class cum sub class3 for SQL Query3
	private static class BankAccountUpdatorByBalance extends SqlUpdate{
		
		public BankAccountUpdatorByBalance(DataSource ds, String query) {
			super(ds, query);  //gives DS, query to super class
			System.out.println("BankDAOImpl.BankAccountUpdatorByBalance.BankAccountUpdatorByBalance()");
			//register query param(?) with jdbc type
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			//Make super class to compile query
			super.compile();
		}
	}//inner class 3
}//class