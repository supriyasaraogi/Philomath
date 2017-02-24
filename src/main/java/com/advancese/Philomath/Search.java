package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

public class Search {
	
	public void search(String searchBy, String value, List<Course> searchResults){
		
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
	        Course course;
	        sql="SELECT * FROM `philoMath`.`Prof_rating` WHERE `"+ searchBy +"` like '%"+value+"%';";
	        System.out.println("'%"+"abc"+"'");
	        System.out.println("Query is "+sql);
	        ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
	        while(rs.next()){
	        	course= new Course();
	        	course.setCategory(rs.getString("category"));
	        	course.setCourseName(rs.getString("course"));
	        	course.setAvailability(rs.getString("availability"));
	        	course.setPricing(rs.getString("pricing"));
	        	String rating=rs.getString("rating");
	        	if(rating==null || rating.isEmpty()){
	        		rating="0";
	        	}
	        	course.setRating(rating);
	        	String numOfVotes=rs.getString("numberOfVotes");
	        	if(numOfVotes==null || numOfVotes.isEmpty()){
	        		numOfVotes="0";
	        	}
	        	course.setNumOfVotes(numOfVotes);
	        	System.out.println("Pricing info is "+course.getPricing());
	        	String pricing= course.getPricing();
	        	if(pricing==null || pricing.isEmpty()){
	        		course.setPricing("Pricing information not available");
	        	}
	        	String availability=course.getAvailability();
	        	if(availability == null || pricing.isEmpty()){
	        		course.setAvailability("Availability information not available");
	        	}
	        	
	        	String email= rs.getString("prof_email");
	        	System.out.println("Email is "+email);
	        	course.setProfessorEmail(email);
	        	String query="SELECT * from `philoMath`.`RegisterUser` WHERE EMAIL like '"+email+"'";
	        	Statement stmt2 = (Statement) conn.createStatement();
	        	ResultSet rs2= stmt2.executeQuery(query);
	        	
	        	while(rs2.next()){
	        		course.setProfessorName(rs2.getString("FullName"));
	        		course.setAddress(rs2.getString("address"));
	        		course.setPhoneNumber(rs2.getString("phoneNumber"));
	        		if(rs2.getString("travel").contains("true")){
	        			course.setTravel("Willing to travel "+rs2.getString("radius"));
	        		}
	        		else{
	        			course.setTravel("Not Willing to travel");
	        		}
		        	
	        		
	        	}
	        	searchResults.add(course);
	        }
	       
	        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}
		
	}
	public void searchByProfessor(String value, List<Course> searchResults){
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://173.194.236.239/philoMath";
        String response;
        //  Database credentials
        String USER = "root";
        String PASS = "";
        String emailid=null;

        Connection conn = null;
        Statement stmt = null;
try{
        Class.forName("com.mysql.jdbc.Driver");

        //Connecting to Database
        conn = DriverManager.getConnection(DB_URL, USER, PASS);


        stmt = (Statement) conn.createStatement();
        String sql;
        Course course;
        
        
        String queryforEmail="SELECT * from `philoMath`.`RegisterUser` WHERE FullName like '%"+value+"%'";
        System.out.println("'%"+"abc"+"'");
    	Statement stmt4 = (Statement) conn.createStatement();
    	 System.out.println(" first Query is "+queryforEmail);
    	 System.out.println("result is "+stmt4.executeQuery(queryforEmail));
    	ResultSet sri =  stmt4.executeQuery(queryforEmail);
    	 System.out.println("next "+sri.next());
    	 
    	 emailid = sri.getString("Email");
        
        sql="SELECT * FROM `philoMath`.`Prof_rating` WHERE `"+ "prof_email" +"` like '"+emailid+"';";
        System.out.println("Query is "+sql);
        ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
        while(rs.next()){
        	course= new Course();
        	course.setCategory(rs.getString("category"));
        	course.setRating(rs.getString("rating"));
        	course.setCourseName(rs.getString("course"));
        	
        	
        	String email= rs.getString("prof_email");
        	System.out.println("Email is "+email);
        	course.setProfessorEmail(email);
        	String query="SELECT * from `philoMath`.`RegisterUser` WHERE EMAIL like '"+email+"'";
        	Statement stmt2 = (Statement) conn.createStatement();
        	ResultSet rs2= stmt2.executeQuery(query);
        	while(rs2.next()){
        		course.setProfessorName(rs2.getString("FullName"));
        		course.setAddress(rs2.getString("address"));
        		course.setPhoneNumber(rs2.getString("phoneNumber"));
        		if(rs2.getString("travel").contains("true")){
        			course.setTravel("Willing to travel "+rs2.getString("radius"));
        		}
        		else{
        			course.setTravel("Not Willing to travel");
        		}
	        	course.setAvailability(rs2.getString("availability"));
	        	course.setPricing(rs2.getString("pricing"));
	        	System.out.println("Pricing info is "+course.getPricing());
	        	String pricing= course.getPricing();
	        	if(pricing==null){
	        		course.setPricing("Pricing information not available");
	        	}
	        	String availability=course.getAvailability();
	        	if(availability == null){
	        		course.setAvailability("Availability information not available");
	        	}
        		
        	}
        	searchResults.add(course);
        }
       
        conn.close();
}
catch(Exception e){
	System.out.println(e);
	response=e.toString();
}

	}
	
	public void compare(List<Course> list1,List<Course> list2, List<Course> finalList){
		int i=list1.size()-1;
		while (i>=0){
			Course c1 = list1.get(i);
			
			int j = list2.size()-1;
			while (j>=0){
				Course c2 = list2.get(j);
				if(c1.getProfessorName().equals(c2.getProfessorName()) && c1.getCourseName().equals(c2.getCourseName())){
					System.out.println("prof name is "+c1.getProfessorName());
					finalList.add(c1);
				}
				j--;
			}
		
		i--;
		}
		
	}
	

}
