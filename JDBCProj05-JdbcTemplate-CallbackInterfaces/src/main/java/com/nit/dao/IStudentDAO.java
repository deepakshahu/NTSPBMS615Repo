package com.nit.dao;

import java.util.List;

import com.nit.model.Student;

public interface IStudentDAO {
	public Student getStudentByNo(int sno);
	public List<Student> getStudentsByCities(String city1, String city2, String city3);
	public List<Student> getStudentsByCities1(String city1, String city2, String city3);
}
