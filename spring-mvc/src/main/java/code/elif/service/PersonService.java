package code.elif.service;

import code.elif.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPersons();

    public Boolean createPerson(Person Person);

    public Person getPerson(Integer id);

    public void deletePerson(Integer id);

    public Person updatePerson(Person Person);

    List<Person> searchPersons(String theSearchName);
}
