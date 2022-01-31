package com.nit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nit.model.Student;

//@Repository("studDAO")
public class StudentDAOImpl1 implements IStudentDAO {

	private static final String GET_STUDENT_BY_NO = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENTS_BY_CITIES = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Student getStudentByNo(int sno) {
		Student stud = jt.queryForObject(GET_STUDENT_BY_NO, new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				//Convert ResultSet record to Student class object
				Student stud = new Student();
				stud.setSno(rs.getInt(1));
				stud.setSname(rs.getString(2));
				stud.setSadd(rs.getString(3));
				stud.setAvg(rs.getFloat(4));
				return stud;
			}//mapRow(-,-)
		}//Anonymous inner class
		, sno);
		return stud;
	}//method

	@Override
	public List<Student> getStudentsByCities(String city1, String city2, String city3) {
		List<Student> studList = jt.query(GET_STUDENTS_BY_CITIES, new ResultSetExtractor<List<Student>>() {

			@Override
			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
				System.out.println("StudentDAOImpl1.getStudentsByCities().extractData()");
				//Copy the multiple RS record to List of Model(Student) class object
				List<Student> listStud = new ArrayList<Student>();
				while(rs.next()) {
					//copy each record of RS into Student class object
					Student stud = new Student();
					stud.setSno(rs.getInt(1));
					stud.setSname(rs.getString(2));
					stud.setSadd(rs.getString(3));
					stud.setAvg(rs.getFloat(4));
					//Add each BO class object to list collection
					listStud.add(stud);
				}//while
				return listStud;
			}//extractData(-)
		}, city1, city2, city3);
		return studList;
	}//method

	@Override
	public List<Student> getStudentsByCities1(String city1, String city2, String city3) {

		List<Student> studList = new ArrayList<>();
		jt.query(GET_STUDENTS_BY_CITIES, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				System.out.println("StudentDAOImpl1.getStudentsByCities1().processRow()");
				//copy RS record into student class object
				Student stud = new Student();
				stud.setSno(rs.getInt(1));
				stud.setSname(rs.getString(2));
				stud.setSadd(rs.getString(3));
				stud.setAvg(rs.getFloat(4));
				studList.add(stud);		
			}
		}, city1, city2, city3);
		return studList;
	}//method
}//class