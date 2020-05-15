package com.elif.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.elif.jpa.Customer;
import com.elif.service.Service;

@Path("customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerRestClient {

	@Inject
	Service<Customer> service;

	@Path("new")
	@POST
	public Response createCustomer(Customer customer) {
		service.create(customer);
		return Response.ok(customer).build();
	}

	@Path("{id}")
	@PUT
	public Response update(@PathParam("id") long id, Customer customer) {

		Customer customerCurrent = (Customer) service.find(id);

		if (customerCurrent == null) {
			return Response.notModified().status(400, "Customer not found!").build();
		}
		customer.setId(id);
		service.update(customer);
		return Response.ok(customer).build();
	}

	@Path("{id}")
	@GET
	public Response getCustomer(@PathParam("id") long id) {
		Customer customer = (Customer) service.find(id);
		return Response.ok(customer).build();
	}

	@Path("list")
	@GET
	public Response listCustomers() {
		List<Customer> customers = service.findAll();
		return Response.ok(customers).build();
	}

}