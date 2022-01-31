package com.nit.controller;

import com.nit.dto.CustomerDTO;
import com.nit.service.ICustomerMgmtService;
import com.nit.vo.CustomerVO;

public class MainController {
	
	//HAS-A property
	private ICustomerMgmtService service;
	
	//Alt+Shift+S,O
	public MainController(ICustomerMgmtService service) {
		System.out.println("MainController :: 1-param constructor");
		this.service = service;
	}
	
	public String processCustomer(CustomerVO vo)throws Exception{
		System.out.println("MainController.processCustomer()");
		//Convert CustomerVO class object to CustomerDTO class object
		CustomerDTO dto = new CustomerDTO();
		dto.setCustName(vo.getCustName());
		dto.setCustAddress(vo.getCustAddress());
		dto.setPamt(Float.parseFloat(vo.getPamt()));
		dto.setRate(Float.parseFloat(vo.getRate()));
		dto.setTime(Float.parseFloat(vo.getTime()));
		
		//Use service
		String result = service.calculateSimpleInterest(dto);
		return result;
	}//method
}//class
