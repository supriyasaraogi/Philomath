package com.advancese.Philomath;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class RegisterDB {
	
	public String insertData(RegisterUser user) {
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

        sql="INSERT INTO `philoMath`.`RegisterUser` (`Email`, `FullName`, `phoneNumber`, `address`, `password`, `securityQuestion`, `answer`, `travel`, `radius`, `tutor` ,`availability`,`pricing`) VALUES ('"+user.email+"','"+user.fullName+"','"+user.phoneNumber+"','"+user.address+"','"+user.password+"','"+user.securityQuestion+"','"+user.answer+"','"+user.travel+"','"+user.radius+"','"+user.tutor+"','"+user.availability+"','"+user.pricing+"')";
        ((java.sql.Statement) stmt).executeUpdate(sql);
        if(user.tutor){
        	sql="INSERT INTO Prof_rating (`prof_email`,`course`,`category`,`availability`,`pricing`) values ('"+user.email+"','"+user.course+"','"+user.category+"','"+user.availability+"','"+user.pricing+"')";
        	((java.sql.Statement) stmt).executeUpdate(sql);
        }
        response="success";
        conn.close();
}
catch(Exception e){
	System.out.println(e);
	response=e.toString();
}
return response;

	}

}
