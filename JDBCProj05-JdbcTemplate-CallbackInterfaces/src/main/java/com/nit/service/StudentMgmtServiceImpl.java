package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.dao.IStudentDAO;
import com.nit.model.Student;

@Service("studService")
public class StudentMgmtServiceImpl implements IStudentMgmtService {

	@Autowired
	private IStudentDAO dao;

	@Override
	public Student fetchStudentByNo(int sno) {
		//Use DAO
		Student stud = dao.getStudentByNo(sno);
		return stud;
	}

	@Override
	public List<Student> fetchStudentByCities(String city1, String city2, String city3) {
		return dao.getStudentsByCities(city1, city2, city3);
	}

	@Override
	public List<Student> fetchStudentByCities1(String city1, String city2, String city3) {
		return dao.getStudentsByCities1(city1, city2, city3);
	}
}//class