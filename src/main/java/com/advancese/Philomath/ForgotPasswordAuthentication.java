package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

public class ForgotPasswordAuthentication {
	
	public JSONObject authenticate(ForgotPasswordUser user){
		
		JSONObject obj=new JSONObject();
		
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

	        sql = "SELECT * FROM RegisterUser where email="+"'"+user.email+"'";
	         ResultSet rs = stmt.executeQuery(sql);
	         String seq="" ;
	         String ans="";
	         
	         if(rs.next()){
	            
	            seq = rs.getString("securityQuestion");
	            ans = rs.getString("answer");
	            
	            
	         }
	       obj.put("seq", seq);
	       obj.put("ans", ans);
	         rs.close();
	         stmt.close();
	         conn.close();
	         
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}
	
		
		
		
		return obj;
	}

}
