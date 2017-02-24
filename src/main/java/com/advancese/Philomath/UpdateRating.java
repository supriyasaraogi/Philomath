package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Statement;

@Path("/updateRating")
public class UpdateRating {
	
	@POST	
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateRating(String request){
		String[] req=request.split(",");
		String email=req[0];
		String course=req[1];
		String rating=req[2];
		String numOfVotes=req[3];

		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	        final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
	        String response;
	        //  Database credentials
	        String USER = "root";
	        String PASS = "";
	        Connection conn = null;
	        Statement stmt = null;
	        String resp="";
	        
	        try{
	        	 Class.forName("com.mysql.jdbc.Driver");

		 	        //Connecting to Database
		 	        conn = DriverManager.getConnection(DB_URL, USER, PASS);


		 	        stmt = (Statement) conn.createStatement();
		 	        String sql;
		 	       
		 	        sql="Update `philoMath`.`Prof_rating` set rating = "+Float.parseFloat(rating)+" WHERE prof_email like '"+email+"' and course like '"+course+"'";
		 	        stmt.executeUpdate(sql);
		 	       sql="Update `philoMath`.`Prof_rating` set numberOfVotes = "+Integer.parseInt(numOfVotes)+" WHERE prof_email like '"+email+"' and course like '"+course+"'";
		 	      stmt.executeUpdate(sql);
		 	      stmt.close();conn.close();
		 	      resp="success";
		 	       
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        	resp="failed";
	        }
	        return resp;
		
		
	}

}
