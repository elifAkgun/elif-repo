package com.elif.rest;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.elif.service.UserSession;

@Path("statefull")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EjbTestClientStatefull {
	
	
	@Inject
	UserSession userSession;
	
	Logger logger;
	
	 //method injection
    @Inject
    public EjbTestClientStatefull(Logger logger) {
    	this.logger = logger;
	}
	
    @Path("{id}")
	@GET
	public Response getTodo(@PathParam("id") int id) {

    	userSession.setUserName( "user : " +id);

    	userSession.getBanks();
		logger.severe("getBanks was called...");
		
		String userName = userSession.getUserName();
		return Response.ok("userName->>> " + userName).build();
	}

}
