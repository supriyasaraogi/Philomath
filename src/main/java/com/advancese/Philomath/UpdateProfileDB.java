package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class UpdateProfileDB {
	
	public String update(String field,String value, String Email){
		
			String result="";
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
		      
		        sql="UPDATE `philoMath`.`RegisterUser` SET `"+ field +"`='"+value+"'  WHERE `Email` like '"+Email+"';";
		        System.out.println("update query is "+sql);
		       ((java.sql.Statement) stmt).executeUpdate(sql);
		       
		       result="success";
		        conn.close();
		}
		catch(Exception e){
			System.out.println(e);
			result=e.toString();
			response=e.toString();
		}
		
		return result;
		
	}

}
