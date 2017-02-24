package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Statement;


@Path("/removeCourseYouTeach")
public class removeCourseYouTeach {
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String remove(String message){
		String[] messageReceived = message.split(",");
		String email=messageReceived[0];
		String course = messageReceived[1];
		
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
	      
	        sql="DELETE FROM `philoMath`.`Prof_rating` WHERE `prof_email` = '"+email+"' and `course` ='"+course+"'";
	        System.out.println("delete query is "+sql);
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
