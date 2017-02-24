package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class ResetPassDB {
	
	public String authenticate(ResetPass reset){
		
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
        String response="";
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

	        sql = "UPDATE RegisterUser SET password="+"'"+reset.password+"' where email="+"'"+reset.email+"'";
	          stmt.executeUpdate(sql);
	    
	         
	        
	       
	         response="success";
	         stmt.close();
	         conn.close();
	         
	}
	catch(Exception e){
		response="failed";
		System.out.println(e);
		response=e.toString();
	}
		
		return response;
	}

}
