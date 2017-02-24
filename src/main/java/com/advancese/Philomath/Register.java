package com.advancese.Philomath;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.JSONP;


@Path("/register")

public class Register {

	RegisterDB reg = new RegisterDB();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUser(RegisterUser user) throws ClassNotFoundException, SQLException{
		
		return reg.insertData(user);
	}
	
}