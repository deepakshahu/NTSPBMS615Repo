package com.nit.service;

import com.nit.dto.CustomerDTO;

public interface ICustomerMgmtService {
	public String calculateSimpleInterest(CustomerDTO dto)throws Exception;
}
