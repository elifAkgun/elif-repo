package service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import entity.Todo;

@Transactional //transform the java object into java service. 
public class TodoService {

	@PersistenceContext
	EntityManager entityManager; //This is JPA provider entity provider. 
	
	@Inject
	Logger log;

	public Todo createTodo(Todo todo) {
		entityManager.persist(todo);
		return todo;
	}

	public Todo updateTodo(Todo todo) {
		entityManager.merge(todo);
		return todo;
	}

	public Todo findTodo(long id) {
		return entityManager.find(Todo.class, id);
	}

	public List<Todo> getTodos() {
		log.log(Level.INFO,"begining of the get entitiy");
		return entityManager.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
	}

}
