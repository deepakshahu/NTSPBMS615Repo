package com.nit.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeMgmtService {
	public int fetchEmpsCount();
	public String fetchEmpNameByEmpNo(int no);
	public Map<String, Object> fetchEmpDetailsByEmpNo(int eno);
	public List<Map<String,Object>> fetchEmpDetailsByDesgs(String desg1,String desg2, String desg3);
	public String fireEmpsOnBench();
	public String depositBonusToEmpsByDesgs(float bonusAmount, String desg1, String desg2);
	public String registerEmployee(String ename, String desg, float salary);
}
