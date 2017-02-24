package com.advancese.Philomath;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.mysql.jdbc.Statement;


@Path("/promote")
public class Promote {
	List<String> list;
	String details="";
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public void promo(String input){
		List<String> list = getEmail();
		System.out.println(input+"input is ");
		String[] in=input.split(";");
		getDetails(in[0], in[1]);
		int index=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals(in[0])){
				index=i;
				break;
			}
		}
		list.remove(index);
		for(int i=0;i<list.size();i++){
			sendSensitivityEmail(list.get(i));
		}
		sendSensitivityEmailToProf(in[0]);
	}
	
	public void getDetails(String email,String course){
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
      System.out.println("details "+email+course);
        sql="select * from Prof_rating where prof_email like '"+email+"' and course like '"+course+"'";
        
      
       String sql2="select FullName, phoneNumber from RegisterUser where Email like '"+email+"'";
       ResultSet rs2= ((java.sql.Statement) stmt).executeQuery(sql2);
       String name=null;
       String phone=null;
       while(rs2.next()){
    	   name=rs2.getString("FullName");
    	   phone=rs2.getString("phoneNumber");
       }
       ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
       while(rs.next()){
    	   System.out.println(rs.getString("availability"));
    	   details=details+"<br> Course Name: "+course;
    	   details=details+"<br> Tutor Name: "+name;
    	   details=details+"<br> Tutor Phone Number: "+phone;
    	   details=details+"<br> Tutor Email: "+email;
    	   details=details+"<br> Availability: "+(rs.getString("availability").isEmpty()?"Contact Tutor for Availability Details":rs.getString("availability"));
    	   details=details+"<br> Pricing: "+(rs.getString("pricing").isEmpty()?"Contact Tutor for Pricing Details":rs.getString("pricing"));
       }
       details=details+"<br><br> Best Regards,<br> PhiloMath Team";
      
        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
		}

	}
	
	public List<String> getEmail(){
		List<String> list=new ArrayList<String>();
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
	      
	        sql="select Email from RegisterUser";
	        
	       ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
	       list.add("srikantv92@gmail.com");
	       while(rs.next()){
	    	   list.add(rs.getString("Email"));
	       }
	      
	        conn.close();
	}
	catch(Exception e){
		System.out.println(e);
		response=e.toString();
	}

		
		return list;
	}
	
	public void sendSensitivityEmail(String to) throws RuntimeException{
		System.out.println("Sending emails..");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = sdf.format(new Date());
		String from = "noreply@philomath.com";
		//String to = "supriya.saraogi1314@gmail.com";
		String subject = "PhiloMath Ad";
		String messagetext = "Hello Students! <br><br> A course has been added in PhiloMath Application. Please find the details of course below -<br>"+details;
		
		final String username = "srikant.vadrevu@gmail.com";//change accordingly
		final String password = "beyblade";//change accordingly

		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
		 new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(username, password);
		    }
		 });

		try {
		 // Create a default MimeMessage object.
		 Message message = new MimeMessage(session);
		 
		 // Set From: hseader field of the header.
		 message.setFrom(new InternetAddress(from));

		 // Set To: header field of the header.
		 message.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse(to));


		 // Set Subject: header field
		 message.setSubject(subject);

		 // Create the message part
		 BodyPart messageBodyPart = new MimeBodyPart();

		 // Now set the actual message
		 messageBodyPart.setHeader("Content-Type", "text/html");
		 //messageBodyPart.setText(messagetext);
		 
		 messageBodyPart.setContent(messagetext, "text/html; charset=utf-8");
		 // Create a multipar message
		 Multipart multipart = new MimeMultipart();

		 // Set text message part
		 multipart.addBodyPart(messageBodyPart);

		
		 message.setContent(multipart);			
		 Transport.send(message);
		 System.out.println("Sent to "+to);

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void sendSensitivityEmailToProf(String to) throws RuntimeException{
		System.out.println("Sending emails..");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = sdf.format(new Date());
		String from = "noreply@philomath.com";
		//String to = "supriya.saraogi1314@gmail.com";
		String subject = "PhiloMath Ad";
		String messagetext = "Hello Tutor, you have successfully requested for Advertisement service. A promotional Email will be sent to all the users of PhiloMath regarding your course details. <br><br> Best Regards,<br>PhiloMath Team";
		
		final String username = "srikant.vadrevu@gmail.com";//change accordingly
		final String password = "beyblade";//change accordingly

		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get the Session object.
		Session session = Session.getInstance(props,
		 new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		       return new PasswordAuthentication(username, password);
		    }
		 });

		try {
		 // Create a default MimeMessage object.
		 Message message = new MimeMessage(session);
		 
		 // Set From: hseader field of the header.
		 message.setFrom(new InternetAddress(from));

		 // Set To: header field of the header.
		 message.setRecipients(Message.RecipientType.TO,
		    InternetAddress.parse(to));


		 // Set Subject: header field
		 message.setSubject(subject);

		 // Create the message part
		 BodyPart messageBodyPart = new MimeBodyPart();

		 // Now set the actual message
		 messageBodyPart.setHeader("Content-Type", "text/html");
		 //messageBodyPart.setText(messagetext);
		 
		 messageBodyPart.setContent(messagetext, "text/html; charset=utf-8");
		 // Create a multipar message
		 Multipart multipart = new MimeMultipart();

		 // Set text message part
		 multipart.addBodyPart(messageBodyPart);

		
		 message.setContent(multipart);			
		 Transport.send(message);
		 System.out.println("Sent to "+to);

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
