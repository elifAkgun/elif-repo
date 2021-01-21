package code.elif.service.impl;

import code.elif.dao.PersonDao;
import code.elif.dao.impl.PersonDaoImpl;
import code.elif.model.Person;
import code.elif.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDaoImpl personDaoImpl;

    public PersonServiceImpl(PersonDaoImpl personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }


    @Override
    public List<Person> getAllPersons() {
        return personDaoImpl.getAllPersons();
    }

    @Override
    public Boolean createPerson(Person person) {
        return personDaoImpl.createPerson(person);
    }

    @Override
    public Person getPerson(Integer id) {
        return personDaoImpl.getPerson(id);
    }

    @Override
    public void deletePerson(Person person) {
        personDaoImpl.deletePerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personDaoImpl.updatePerson(person);
    }
}
