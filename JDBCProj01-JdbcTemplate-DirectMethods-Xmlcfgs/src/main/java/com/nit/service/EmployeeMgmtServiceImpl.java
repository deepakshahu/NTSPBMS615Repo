package com.nit.service;

import java.util.List;
import java.util.Map;

import com.nit.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		this.dao=dao;
	}

	@Override
	public int fetchEmpsCount() {
		//Use dao
		return dao.getEmpsCount();
	}

	@Override
	public String fetchEmpNameByEmpNo(int no) {
		//Use dao
		return dao.getEmpNameByEmpNo(no);
	}

	@Override
	public Map<String, Object> fetchEmpDetailsByEmpNo(int eno) {
		//Use dao
		return dao.getEmpDetailsByEmpNo(eno);
	}

	@Override
	public List<Map<String, Object>> fetchEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		//Use dao
		return dao.getEmpDetailsByDesgs(desg1, desg2, desg3);
	}
	
	@Override
	public String fireEmpsOnBench() {
		//Use dao
		int count = dao.deleteEmpsNotHavingDeptNo();
		return count+" emps are fired because they do not have desgs";
	}
	
	@Override
	public String depositBonusToEmpsByDesgs(float bonusAmount, String desg1, String desg2) {
		//Use dao
		int count = dao.addBonusToEmpsByDesgs(desg1, desg2, bonusAmount);
		return count+" no of employess are benefited with bonus";
	}

	@Override
	public String registerEmployee(String ename, String desg, float salary) {
		//Use dao
		int count = dao.insertEmployee(ename, desg, salary);
		return count==0?"Employee not registered":"Employee registered";  //ternary operator
	}	
}