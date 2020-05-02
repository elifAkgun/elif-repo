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

import com.elif.jpa.Animal;
import com.elif.service.AnimalService;

@Path("animal")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON )
public class RestClient {
	
	@Inject
	AnimalService service;

	@Path("new")
	@POST
	public Response  createAnimal(Animal animal) {
		service.createAnimal(animal);
		return Response.ok(animal).build() ;
	}

	@Path("update")
	@PUT
	public Response  updateAnimal(Animal animal) {
		service.updateAnimal(animal);
		return Response.ok(animal).build() ;
	}

	@Path("{id}")
	@GET
	public Response  getAnimal(@PathParam("id") long id) {
		Animal animal = service.findAnimal(id);
		return Response.ok(animal).build() ;
	}

	@Path("list")
	@GET
	public Response  listAnimals() { 
		List<Animal> animals = service.getAnimals();
		return Response.ok(animals).build() ;
	}


}
