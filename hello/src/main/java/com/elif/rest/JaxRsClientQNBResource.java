package com.elif.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("qnb")
@Produces(MediaType.APPLICATION_JSON)
public class JaxRsClientQNBResource {

	@Inject
	JaxRsClient jaxRsClient;

	@Path("cards")
	@GET
	public Response getCards(@Context HttpHeaders headers) {

		List<String> authHeaders = headers.getRequestHeader(HttpHeaders.AUTHORIZATION);

		String breaches1 = jaxRsClient.getCards(authHeaders.get(0), null);
		return Response.ok(breaches1).build();
	}
	
	@Path("cards/{cardId}")
	@GET
	public Response getCards(@Context HttpHeaders headers, @PathParam("cardId") String cardId) {

		List<String> authHeaders = headers.getRequestHeader(HttpHeaders.AUTHORIZATION);

		String breaches1 = jaxRsClient.getCards(authHeaders.get(0), cardId);
		return Response.ok(breaches1).build();
	}
}
