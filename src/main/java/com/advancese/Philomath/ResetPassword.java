package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resetpassword")
public class ResetPassword {
	ResetPassDB resetDb = new ResetPassDB();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String reset(ResetPass reset){
		String result= resetDb.authenticate(reset);
		return result;
	}
	
	
}
