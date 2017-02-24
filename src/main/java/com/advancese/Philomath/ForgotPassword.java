package com.advancese.Philomath;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

@Path("/forgotpassword")
public class ForgotPassword {
	
	ForgotPasswordAuthentication auth = new ForgotPasswordAuthentication();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String forgot(ForgotPasswordUser user){
		
		 JSONObject obj= auth.authenticate(user);
		 return obj.toJSONString();
	}
	
}
