package com.advancese.Philomath;

import java.lang.annotation.Annotation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.persistence.oxm.JSONWithPadding;
import org.glassfish.jersey.server.JSONP;
import org.json.simple.JSONObject;

@Path("/webdata")
public class WebData {
	
	@GET
	@JSONP
	@Produces("application/javascript")
	public JSAPI  webdata(){
		
		//student-1 details
		Student student1= new Student();
		student1.setAge("12");
		student1.setFirstName("Srikant");
		student1.setLastName("Vadrevu");
		Address address1= new Address();
		address1.setLatitude("23");
		address1.setLongitude("45");
		student1.setAddress(address1);
		
		//student-2 details
		Student student2= new Student();
		student2.setAge("14");
		student2.setFirstName("foo");
		student2.setLastName("bar");
		Address address2= new Address();
		address2.setLatitude("26");
		address2.setLongitude("25");
		student2.setAddress(address2);
		
		//student-3 details
		Student student3= new Student();
		student3.setAge("19");
		student3.setFirstName("Steve");
		student3.setLastName("Emmons");
		Address address3= new Address();
		address3.setLatitude("77");
		address3.setLongitude("55");
		student3.setAddress(address3);
				
		//student-4 details
				Student student4= new Student();
				student4.setAge("22");
				student4.setFirstName("Jinny");
				student4.setLastName("Mcburney");
				Address address4= new Address();
				address4.setLatitude("45");
				address4.setLongitude("75");
				student4.setAddress(address4);
				
				//student-5 details
				Student student5= new Student();
				student5.setAge("79");
				student5.setFirstName("Cody");
				student5.setLastName("Such");
				Address address5= new Address();
				address5.setLatitude("34");
				address5.setLongitude("15");
				student5.setAddress(address5);								

				//student-6 details
				Student student6= new Student();
				student6.setAge("09");
				student6.setFirstName("Raleigh");
				student6.setLastName("Bock");
				Address address6= new Address();
				address6.setLatitude("77");
				address6.setLongitude("50");
				student6.setAddress(address6);								
		

				//student-7 details
				Student student7= new Student();
				student7.setAge("86");
				student7.setFirstName("Deidre");
				student7.setLastName("Pegues");
				Address address7= new Address();
				address7.setLatitude("66");
				address7.setLongitude("55");
				student7.setAddress(address7);	
				
				//student-8 details
				Student student8= new Student();
				student8.setAge("59");
				student8.setFirstName("Meda");
				student8.setLastName("Bump");
				Address address8= new Address();
				address8.setLatitude("73");
				address8.setLongitude("75");
				student8.setAddress(address8);
				
				//student-9 details
				Student student9= new Student();
				student9.setAge("19");
				student9.setFirstName("Marylyn");
				student9.setLastName("Dines");
				Address address9= new Address();
				address9.setLatitude("54");
				address9.setLongitude("53");
				student9.setAddress(address9);
				
				//student-10 details
				Student student10= new Student();
				student10.setAge("29");
				student10.setFirstName("Kyla");
				student10.setLastName("Porsha");
				Address address10= new Address();
				address10.setLatitude("32");
				address10.setLongitude("43");
				student10.setAddress(address10);								
		
						
						
						
				
		JSAPI j= new JSAPI();
		j.setStudent1(student1);
		j.setStudent2(student2);
		j.setStudent3(student3);
		j.setStudent4(student4);
		j.setStudent5(student5);
		j.setStudent6(student6);
		j.setStudent7(student7);
		j.setStudent8(student8);
		j.setStudent9(student9);
		j.setStudent10(student10);
		
		return j ;
	}

}
