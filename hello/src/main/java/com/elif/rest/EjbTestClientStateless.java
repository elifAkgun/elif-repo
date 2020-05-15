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

import com.elif.service.QueryService;

@Path("stateless")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EjbTestClientStateless {

	@Inject
	QueryService queryService;

	Logger logger;

	// method injection
	@Inject
	public EjbTestClientStateless(Logger logger) {
		this.logger = logger;
	}

	@Path("{id}")
	@GET
	public Response getTodo(@PathParam("id") int id) {

		queryService.setQueryId(id);

		queryService.getBanks();
		logger.severe("getBanks was called...");
		queryService.getCustomers();
		logger.severe("getCustomers was called...");

		int queryId = queryService.getQueryId();
		return Response.ok("QueryId->>> " + queryId).build();
	}

}
