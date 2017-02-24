package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/updateProfile")
public class UpdateProfile {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProfile(Update update){
		System.out.println("received email is "+update.getEmail());
		Edit profile = new Edit();
		String email= update.getEmail();
		GetProfile get= new GetProfile();
		get.getProfile(email, profile);
		System.out.println("profile phone num is "+profile.getPhoneNum());
		UpdateProfileDB up= new UpdateProfileDB();
		String response="";
		if(!profile.getName().equals(update.getName())){
			response= up.update("FullName",update.getName(), update.getEmail());
			if(!response.contains("success")){
				return "failed";
			}
		}
		
		if(!profile.getAddress().equals(update.getAddress())){
			response=up.update("address",update.getAddress(), update.getEmail());
			if(!response.contains("success")){
				return "failed";
			}
		}
		/*
		if(!profile.getAvailability().equals(update.getAvailability())){
			up.update("availability",update.getName(), update.getEmail());
		}*/
		
		if(!profile.getPassword().equals(update.getPassword())){
			response=up.update("password",update.getPassword(), update.getEmail());
			if(!response.contains("success")){
				return "failed";
			}
		}
		
		if(!profile.getPhoneNum().equals(update.getPhoneNum())){
			response=up.update("phoneNumber",update.getPhoneNum(), update.getEmail());
			if(!response.contains("success")){
				return "failed";
			}
		}
		
	/*	if(!profile.getPricing().equals(update.getPricing())){
			up.update("pricing",update.getPricing(), update.getEmail());
		}
		
		if(!update.getCourses().containsAll(profile.getCourses())){
			
		}
		
		if(!update.getCoursesTakenAsStudent().containsAll(profile.getCoursesTakenAsStudent())){
			
		}*/
		return response;
	}
}
