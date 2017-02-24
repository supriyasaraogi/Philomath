package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/editProfile")
public class EditProfile {
	
	Edit e = new Edit();
	
	GetProfile g = new GetProfile();
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Edit editProfile(String emailID){
		g.getProfile(emailID, e);
		
		System.out.println("passowrd is "+e.getPassword());
		return e;
		
	}

}
