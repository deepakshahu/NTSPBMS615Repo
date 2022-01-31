package com.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nit.dto.EmployeeDTO;
import com.nit.service.IEmployeeMgmtService;
import com.nit.vo.EmployeeVO;

@Controller("controller")
public class MainController {
	//HAS-A property
	@Autowired
	private IEmployeeMgmtService service;
	
	public String processEmployee(EmployeeVO vo)throws Exception{
		System.out.println("MainController.processEmployee()");
		//Convert EmployeeVO class object to EmployeeDTO class object
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		
		//use service
		String result=service.registerEmployee(dto);
		return result;
	}//method
}//class
