package com.nit.service;

import java.util.List;

import com.nit.model.Student;

public interface IStudentMgmtService {
	public Student fetchStudentByNo(int sno);
	public List<Student> fetchStudentByCities(String city1, String city2, String city3);
	public List<Student> fetchStudentByCities1(String city1, String city2, String city3);
}
