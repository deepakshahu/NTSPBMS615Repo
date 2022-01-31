package com.nit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nit.model.Student;

//@Repository("studDAO")
public class StudentDAOImpl3 implements IStudentDAO {

	private static final String GET_STUDENT_BY_NO = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENTS_BY_CITIES = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Student getStudentByNo(int sno) {
		Student stud = jt.queryForObject(GET_STUDENT_BY_NO, new BeanPropertyRowMapper<Student>(Student.class), sno);  //Readymade impl class
		return stud;
	}//method

	@Override
	public List<Student> getStudentsByCities(String city1, String city2, String city3) {
		//Create BeanPropertyRowMapper class object that helps to copy each record into one BO class object
		BeanPropertyRowMapper<Student> bprm = new BeanPropertyRowMapper<Student>(Student.class);
		List<Student> studList = jt.query(GET_STUDENTS_BY_CITIES, new RowMapperResultSetExtractor<Student>(bprm), city1, city2, city3);
		return studList;
	}//method

	@Override
	public List<Student> getStudentsByCities1(String city1, String city2, String city3) {
		// TODO Auto-generated method stub
		return null;
	}
}//class