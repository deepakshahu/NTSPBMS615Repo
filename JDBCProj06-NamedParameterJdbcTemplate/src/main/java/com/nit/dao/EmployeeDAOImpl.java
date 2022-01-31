package com.nit.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	
	private static final String GET_EMPNAME_BY_NO = "SELECT ENAME FROM EMP WHERE EMPNO=:no";
	private static final String GET_EMPDETAILS_BY_DESGS = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE JOB IN(:desg1,:desg2,:desg3)";
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES (:empNo,:ename,:job,:sal)";
	
	@Autowired
	private NamedParameterJdbcTemplate npjt;

	@Override
	public String getEnameByNo(int no) {
		/*Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("no", no);*/
		Map<String,Object> paramMap = Map.of("no",no);  //java9
		String name = npjt.queryForObject(GET_EMPNAME_BY_NO, paramMap, String.class);
		return name;
	}//method

	@Override
	public List<Employee> getEmpDetailsByDesgs(String desg1, String desg2, String desg3) {
		//prepare MapSqlParameterSource class object having the names, values of the named parameters
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("desg1", desg1);
		msps.addValue("desg2", desg2);
		msps.addValue("desg3", desg3);
		List<Employee> empsList = npjt.query(GET_EMPDETAILS_BY_DESGS, msps, rs->{  //LAMBDA expression based anonymous inner class for ResultSetExtractor
			List<Employee> ListEmps = new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				emp.setSal(rs.getFloat(4));
				ListEmps.add(emp);
			}//while
			return ListEmps;
		});
		return empsList;
	}//method

	@Override
	public int insertEmployee(Employee emp) {
		//Create BeanPropertySqlParameterSource object having Employee class object values as the named parameter values	
		BeanPropertySqlParameterSource bpsps = new BeanPropertySqlParameterSource(emp);
		//Execute query
		int count = npjt.update(INSERT_EMPLOYEE, bpsps);
		return count;
	}
}//class