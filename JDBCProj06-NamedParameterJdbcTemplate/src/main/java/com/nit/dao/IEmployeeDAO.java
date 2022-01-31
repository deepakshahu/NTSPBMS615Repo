package com.nit.dao;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeDAO {
	public String getEnameByNo(int no);
	public List<Employee> getEmpDetailsByDesgs(String desg1, String desg2, String desg3);
	public int insertEmployee(Employee emp);
}
