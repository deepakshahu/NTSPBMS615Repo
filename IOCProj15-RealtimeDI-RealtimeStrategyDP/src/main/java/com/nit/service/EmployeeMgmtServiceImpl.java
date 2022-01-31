package com.nit.service;

import com.nit.bo.EmployeeBO;
import com.nit.dao.IEmployeeDAO;
import com.nit.dto.EmployeeDTO;

public final class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	//HAS-A property
	private IEmployeeDAO dao;
	
	public EmployeeMgmtServiceImpl(IEmployeeDAO dao) {
		System.out.println("EmployeeMgmtServiceImpl :: 1-param constructor");
		this.dao=dao;
	}

	@Override
	public String registerEmployee(EmployeeDTO dto) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.registerEmployee()");
		
		//Write b.logic to calculate grossSalary and netSalary
		float grossSalary = dto.getBasicSalary()+dto.getBasicSalary()*0.4f;  //+40% in basicSalary	
		float netSalary = grossSalary-dto.getBasicSalary()*0.25f;  //-20% on grossSalary
		
		//Prepare EmployeeBO class object having persistable data
		EmployeeBO bo = new EmployeeBO();
		bo.setEname(dto.getEname());
		bo.setDesg(dto.getDesg());
		bo.setBasicSalary(dto.getBasicSalary());
		bo.setGrossSalary(grossSalary);
		bo.setNetSalary(netSalary);
		
		//Use DAO
		int count = dao.insertEmployee(bo);
		
		//Generate final result
		return count==1?"Employee registered with netSalary :: "+netSalary:"Employee not registered with netSalary :: "+netSalary;  //ternary operator
	}//method
}//class