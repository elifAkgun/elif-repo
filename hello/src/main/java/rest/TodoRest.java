package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entity.Todo;
import service.TodoService;


//This is basic POJO 
//This class is mapped with DB table.
@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON )
public class TodoRest {
	
	@Inject
	TodoService service;
	
	@Path("new")
	@POST
	public Response  createTodo(Todo todo) {
		service.createTodo(todo);
		return Response.ok(todo).build() ;
	}
	
	@Path("update")
	@PUT
	public Response  updateTodo(Todo todo) {
		service.updateTodo(todo);
		return Response.ok(todo).build() ;
	}
	
	@Path("{id}")
	@GET
	public Response  getTodo(@PathParam("id") long id) {
		Todo todo = service.findTodo(id);
		return Response.ok(todo).build() ;
	}
	
	@Path("list")
	@GET
	public Response  listTodos() { 
		List<Todo> todos = service.getTodos();
		return Response.ok(todos).build() ;
	}
	
	@Path("complete")
	@POST
	public Response  markAsCompleted(@QueryParam ("id") long id) { 
		Todo todo = service.findTodo(id);
		todo.setCompleted(true);
		service.updateTodo(todo);
		return Response.ok(todo).build() ;
	}

}
