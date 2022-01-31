package com.nit.service;

import com.nit.bo.CustomerBO;
import com.nit.dao.ICustomerDAO;
import com.nit.dto.CustomerDTO;

public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	//HAS-A property
	private ICustomerDAO dao;
	
	//Alt+Shift+S,O
	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl :: 1-param constructor");
		this.dao = dao;
	}

	@Override
	public String calculateSimpleInterest(CustomerDTO dto) throws Exception {
		System.out.println("CustomerMgmtServiceImpl.calculateSimpleInterest()");
		//Calculate Simple Interest amount
		float intrAmt = (dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		
		//Create BO class obj having persistable data
		CustomerBO bo = new CustomerBO();
		bo.setCustName(dto.getCustName());
		bo.setCustAddress(dto.getCustAddress());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setInterestAmount(intrAmt);
		
		//Use DAO
		int count = dao.insertCustomer(bo);
		
		// ternary operator   <condition>?<success>:<failure>
		return count==1?"Customer registered sucessfully---> SimpleIntrest amount::"+intrAmt:"Customer registration failed"; 
	}//method
}//class