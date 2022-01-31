package com.nit.service;

import java.util.List;

import com.nit.model.Employee;

public interface IEmployeeMgmtService {
	public String fetchEmpNameByNo(int no);
	public List<Employee> fetchEmpDetailsByDesgs(String desg1, String desg2, String desg3);
	public String registerEmployee(Employee emp);
}
