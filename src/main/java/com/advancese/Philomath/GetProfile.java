package com.advancese.Philomath;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class GetProfile {
	
	public void getProfile(String email, Edit edit){
		  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	        final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
	        String response;
	        //  Database credentials
	        String USER = "root";
	        String PASS = "";

	        Connection conn = null;
	        Statement stmt = null;
	try{
	        Class.forName("com.mysql.jdbc.Driver");

	        //Connecting to Database
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);


	        stmt = (Statement) conn.createStatement();
	        String sql;

	        sql="SELECT * FROM `philoMath`.`RegisterUser` WHERE Email like '"+email+"';";
	        ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
	        while(rs.next()){
	        	edit.setName(rs.getString("FullName"));
	        	
	        	edit.setAddress(rs.getString("address"));
	        	edit.setPassword(rs.getString("password"));
	        	edit.setPhoneNum(rs.getString("phoneNumber"));
	        	
	        	edit.setTravel(rs.getBoolean("travel"));
	        	
	        	edit.setTutor(rs.getBoolean("tutor"));
	        }
	        sql="SELECT * FROM Prof_rating WHERE prof_email like '"+email+"';";
	        ResultSet rs1 = ((java.sql.Statement) stmt).executeQuery(sql);
	        ArrayList courses = new ArrayList();
        	
        	
	        while(rs1.next()){
	        	courses.add(rs1.getString("course"));
	        	edit.setAvailability(rs1.getString("availability"));
	        	edit.setPricing(rs1.getString("pricing"));
	        }
	        edit.setCourses(courses);
	        
	        sql="SELECT * FROM Student_courses WHERE email like '"+email+"';";
	        ResultSet rs2 = ((java.sql.Statement) stmt).executeQuery(sql);
	        ArrayList coursesTakenAsStudent = new ArrayList();
	        while(rs2.next()){
	        	coursesTakenAsStudent.add(rs2.getString("course"));
	        }
	        edit.setCoursesTakenAsStudent(coursesTakenAsStudent);
	        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}
	

		}
		
	}


