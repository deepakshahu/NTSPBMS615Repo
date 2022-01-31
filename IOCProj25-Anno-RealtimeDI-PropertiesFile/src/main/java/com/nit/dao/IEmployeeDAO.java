package com.nit.dao;

import com.nit.bo.EmployeeBO;

public interface IEmployeeDAO {
	public int insertEmployee(EmployeeBO bo) throws Exception;
}
