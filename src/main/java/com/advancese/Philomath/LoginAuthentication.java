package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Statement;

public class LoginAuthentication {
	
	public String authenticate(LoginUser login){
		
		
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

	        sql = "SELECT * FROM RegisterUser";
	         ResultSet rs = stmt.executeQuery(sql);
	         
	         while(rs.next()){
	            
	            String user = rs.getString("Email");
	            String pwd = rs.getString("password");
	            System.out.println(user+pwd);
	            if(login.email.equals(user)&& login.password.equals(pwd))
	            	return "success";
	            
	         }
	         rs.close();
	         stmt.close();
	         conn.close();
	         return "failed";
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}
	return response;
		
	}

}
