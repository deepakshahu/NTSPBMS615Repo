package com.nit.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("authDAO")
public class AuthenticationDAOImpl implements IAuthenticationDAO {
	
	@Autowired
	private SimpleJdbcCall sjc;

	@Override
	public String authentication(String user, String pwd) {
		//Set procedure name
		sjc.setProcedureName("P_AUTHENTICATION");
		//Prepare map of IN params
		Map<String, Object> inParams = Map.of("USERNAME",user,"PASSWORD",pwd);//java9
		//Call PL/SQL procedure
		Map<String, Object> outParams = sjc.execute(inParams);
		return (String) outParams.get("RESULT");
	}//method
}//class