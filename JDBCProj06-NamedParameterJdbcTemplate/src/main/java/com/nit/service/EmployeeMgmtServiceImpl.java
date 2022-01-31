package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IEmployeeDAO;
import com.nit.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public String fetchEmpNameByNo(int no) {
		//Use DAO
		String name = dao.getEnameByNo(no);
		return name;
	}//method

	@Override
	public List<Employee> fetchEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		//Use DAO
		return dao.getEmpDetailsByDesgs(desg1, desg2, desg3);
	}//method

	@Override
	public String registerEmployee(Employee emp) {
		//Use DAO
		int count = dao.insertEmployee(emp);
		return count==1?"Employee registered":"Employee not registered";
	}//method
}//class