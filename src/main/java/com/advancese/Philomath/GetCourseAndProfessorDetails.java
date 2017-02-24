package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.Statement;

@Path("/GetCourseAndProfessorDetails")
public class GetCourseAndProfessorDetails {
	
	@GET
	@Path("/{para}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDetails(@PathParam("para") String email){
		
		JSONArray res= new JSONArray();
		
		/*String helpfulness="";
    	String clarity="";
    	String easiness="";
    	String overall="";*/
		
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

	 	        sql="SELECT * FROM `philoMath`.`Student_courses` WHERE Email like '"+email+"';";
	 	       ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
		        while(rs.next()){
		        	JSONObject o= new JSONObject();
		        	String cours=rs.getString("course");
		        	o.put("course", cours);
		        	
		        	String prof=rs.getString("professor");
		        	o.put("professor", prof);
		        	o.put("helpfulness", rs.getString("helpfulness"));
		        	o.put("clarity",rs.getString("clarity"));
		        	o.put("easiness",rs.getString("easiness"));
		        	o.put("overall",rs.getString("overall"));
		        	
		        	String email2=profEmail(prof);
		        	o.put("profEmail", email2);
		        	/*String sql3="SELECT * FROM `philoMath`.`RegisterUser` WHERE FullName like '%"+prof+"%'";
		        	ResultSet rs3 = stmt.executeQuery(sql3);
		        	String email2="";
		        	while(rs3.next()){
		        		email2=rs3.getString("Email");
		        		System.out.println("email is "+email2);
		        	}*/
		        	
		        	getCourse(o,email2,cours);
		        	res.add(o);
		        	/*String sql2="SELECT * FROM `philoMath`.`Prof_rating` WHERE prof_email like '"+email2+"' and course like '"+cours+"'";
		        	ResultSet rs2 = stmt.executeQuery(sql2);
		        	while(rs2.next()){
		        		rating.add(rs2.getString("rating"));
		        		numOfVotes.add(rs2.getString("numberOfVotes"));
		        	}*/
		        	
		        }
		       
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        
	        JSONObject obj= new JSONObject();
	        obj.put("results", res);
	     
	        
	        return obj.toString();
		
	}
	
	public void getCourse(JSONObject o,String email2,String cours ){
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
	 	       o.put("rating","0");
       		o.put("numberOfVotes","0");
	 	       String sql2="SELECT * FROM `philoMath`.`Prof_rating` WHERE prof_email like '"+email2+"' and course like '"+cours+"'";
	        	ResultSet rs2 = stmt.executeQuery(sql2);
	        	while(rs2.next()){
	        		o.put("rating",rs2.getString("rating"));
	        		o.put("numberOfVotes",rs2.getString("numberOfVotes"));
	        	}
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }
	}
	
	public String profEmail( String prof){
		 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	        final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
	        String response;
	        //  Database credentials
	        String USER = "root";
	        String PASS = "";
	        Connection conn = null;
	        Statement stmt = null;
	        String email2="";
	        try{
	        	Class.forName("com.mysql.jdbc.Driver");

	 	        //Connecting to Database
	 	        conn = DriverManager.getConnection(DB_URL, USER, PASS);


	 	        stmt = (Statement) conn.createStatement();
	 	       String sql3="SELECT * FROM `philoMath`.`RegisterUser` WHERE FullName like '%"+prof+"%'";
	        	ResultSet rs3 = stmt.executeQuery(sql3);
	        	
	        	while(rs3.next()){
	        		email2=rs3.getString("Email");
	        		System.out.println("email is "+email2);
	        	}
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }
	        return email2;
	}

}
