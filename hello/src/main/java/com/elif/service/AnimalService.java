package com.elif.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.elif.jpa.Animal;

@Transactional
public class AnimalService {
	
	@PersistenceContext(name = "myPU")
	EntityManager entityManager; //This is JPA provider entity provider. 

	public Animal createAnimal(Animal animal) {
		entityManager.persist(animal);
		return animal;
	}

	public Animal updateAnimal(Animal animal) {
		entityManager.merge(animal);
		return animal;
	}

	public Animal findAnimal(long id) {
		return entityManager.find(Animal.class, id);
	}

	public List<Animal> getAnimals() {
		return entityManager.createQuery("SELECT t FROM ANIMAL t", Animal.class).getResultList();
	}

}
