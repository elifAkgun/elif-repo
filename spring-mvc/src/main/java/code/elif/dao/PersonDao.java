package code.elif.dao;

import code.elif.model.Person;

import javax.sql.DataSource;
import java.util.List;

public interface PersonDao {

    public void setDataSource(DataSource dataSource);

    public List<Person> getAllPersons();

    public Boolean createPerson(Person Person);

    public Person getPerson(Integer id);

    public void deletePerson(Integer id);

    public Person updatePerson(Person Person);

    List<Person> searchPersons(String theSearchName);
}
