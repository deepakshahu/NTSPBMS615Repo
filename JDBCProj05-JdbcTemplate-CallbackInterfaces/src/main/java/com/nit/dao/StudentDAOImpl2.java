package com.nit.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nit.model.Student;

@Repository("studDAO")
public class StudentDAOImpl2 implements IStudentDAO {

	private static final String GET_STUDENT_BY_NO = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SNO=?";
	private static final String GET_STUDENTS_BY_CITIES = "SELECT SNO,SNAME,SADD,AVG FROM STUDENT WHERE SADD IN(?,?,?)";

	@Autowired
	private JdbcTemplate jt;

	@Override
	public Student getStudentByNo(int sno) {
		Student stud = jt.queryForObject(GET_STUDENT_BY_NO, (rs, rowNum)->{
			//copy RS record to Student class object
			Student stud1 = new Student();
			stud1.setSno(rs.getInt(1));
			stud1.setSname(rs.getString(2));
			stud1.setSadd(rs.getString(3));
			stud1.setAvg(rs.getFloat(4));
			return stud1;
		}//mapRow(-,-)
		, sno);
		return stud;
	}//method

	@Override
	public List<Student> getStudentsByCities(String city1, String city2, String city3) {
		List<Student> studList = jt.query(GET_STUDENTS_BY_CITIES, rs->{
			//copy RS record to List of Student collection
			List<Student> listStud = new ArrayList<Student>();
			while(rs.next()) {
				//copy RS record into Student class object
				Student stud = new Student();
				stud.setSno(rs.getInt(1));
				stud.setSname(rs.getString(2));
				stud.setSadd(rs.getString(3));
				stud.setAvg(rs.getFloat(4));
				//Add each student class object to list collection
				listStud.add(stud);
			}//while
			return listStud;
		}, city1, city2, city3);
		return studList;
	}//method

	@Override
	public List<Student> getStudentsByCities1(String city1, String city2, String city3) {
		List<Student> listStud = new ArrayList<>();
		jt.query(GET_STUDENTS_BY_CITIES, rs->{
			System.out.println("StudentDAOImpl2.getStudentsByCities1().LAMBDA");
			//copy RS record into Student class object
			Student stud = new Student();
			stud.setSno(rs.getInt(1));
			stud.setSname(rs.getString(2));
			stud.setSadd(rs.getString(3));
			stud.setAvg(rs.getFloat(4));
			//Add each student class object to list collection
			listStud.add(stud);
		}, city1, city2, city3);
		return listStud;
	}//method
}//class