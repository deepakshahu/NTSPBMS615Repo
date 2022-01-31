package com.nit.dao;

import com.nit.bo.CustomerBO;

public interface ICustomerDAO {
	public int insertCustomer(CustomerBO bo) throws Exception;
}
