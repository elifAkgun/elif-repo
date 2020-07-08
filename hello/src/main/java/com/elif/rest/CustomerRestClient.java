package com.elif.rest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.elif.caching.CachControlConfig;
import com.elif.config.security.Secure;
import com.elif.entity.Customer;
import com.elif.service.Service;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestClient {

	@Context
	private UriInfo uriInfo;

	@Inject
	Service<Customer> customerService;
	
	 @Inject
	 JaxRsClient jaxRsClient;


	@POST
	public Response createCustomer(@Valid Customer customer, @HeaderParam("Referer") String referer) {
		customerService.save(customer);
		URI uri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();

		URI others = uriInfo.getBaseUriBuilder().path(CustomerRestClient.class)
				.path(CustomerRestClient.class, "listCustomers").build();

		JsonObjectBuilder links = Json.createObjectBuilder().add("_links", Json.createArrayBuilder().add(
				Json.createObjectBuilder().add("_others", others.toString()).add("_self", uri.toString()).build()));

		System.out.println(referer);
		jaxRsClient.postEmployeeToSSE(customer);
		
        return Response.ok(links.build().toString()).status(Response.Status.CREATED).build();
	}

	@Path("{id}")
	@PUT
	public Response update(@PathParam("id") long id, Customer customer) {

		Customer customerCurrent = (Customer) customerService.find(id);

		if (customerCurrent == null) {
			return Response.notModified().status(400, "Customer not found!").build();
		}
		customer.setId(id);
		customerService.save(customer);
		return Response.ok(customer).build();
	}

	@Path("{id}")
	@GET
	public Response getCustomer(@PathParam("id") long id, @Context Request request) {
		Customer customer = (Customer) customerService.find(id);

		if (customer == null) {
			return Response.notModified().status(400, "Customer not found!").build();
		}

		EntityTag entityTag = new EntityTag(Integer.toString(customer.hashCode()));

		Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(entityTag);

		return responseBuilder.build();
	}

	@GET
	@CachControlConfig(maxAge = 100, noCache = true, noStore = true)
	@Secure
	@Path("list")
	public Response listCustomers() {
		List<Customer> customers = customerService.findAll();
		return Response.ok(customers).build();
	}

	@POST
	@Path("upload") // employees/upload?id=9
	@Consumes({ MediaType.APPLICATION_OCTET_STREAM, "image/png", "image/jpeg", "image/jpg" })
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadPicture(File picture, @QueryParam("id") @NotNull Long id) {

		Customer customer = customerService.find(id);

		try (Reader reader = new FileReader(picture)) {

			customer.setPicture(Files.readAllBytes(Paths.get(picture.toURI())));
			customerService.save(customer);

			int totalsize = 0;
			int count = 0;
			final char[] buffer = new char[256];
			while ((count = reader.read(buffer)) != -1) {
				totalsize += count;
			}
			return Response.ok(totalsize).build();
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@GET
	@Path("download") // employees/download?id=9
	@Produces({ MediaType.APPLICATION_OCTET_STREAM, "image/jpg", "image/png", "image/jpeg" })
	public Response getCustomerPicture(@QueryParam("id") @NotNull Long id) throws IOException {

		NewCookie userId = new NewCookie("userId", id.toString());

		Customer customer = customerService.find(id);
		if (customer != null) {
			return Response.ok().entity(Files.write(Paths.get("pic.png"), customer.getPicture()).toFile())
					.cookie(userId).build();
		}

		return Response.noContent().build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteCustomer(@PathParam("id") long id) {
		Customer customer = (Customer) customerService.find(id);

		if (customer == null) {
			return Response.notModified().status(400, "Customer not found!").build();
		}

		customerService.delete(customer);
		return Response.ok().build();
	}
}
