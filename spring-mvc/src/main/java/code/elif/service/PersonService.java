package code.elif.service;

import code.elif.model.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPersons();

    public Boolean createPerson(Person Person);

    public Person getPerson(Integer id);

    public void deletePerson(Person Person);

    public Person updatePerson(Person Person);
}
