package code.elif.dao.impl;

import code.elif.dao.PersonDao;
import code.elif.dao.impl.rowMapper.PersonRowMapper;
import code.elif.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;

@Repository("personDaoComp")
public class PersonDaoImpl implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate= new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    @Override
    public Boolean createPerson(Person person) {
        Object[] args = {person.getName(),person.getSurName(),person.getBirthDate() };
        return  jdbcTemplate.update("INSERT INTO person ('id', 'name', 'sur_name', 'birth_date')" +
                " VALUES (?,?,?)",args)==1;
    }

    @Override
    public Person getPerson(Integer id) {
        String sql = "SELECT * FROM person WHERE id=?";
        Object[] args =new Object[] {id};
        Person person = jdbcTemplate.queryForObject(sql, new PersonRowMapper(),args);
        return person;
    }

    @Override
    public void deletePerson(Person person) {
        String sql = "DELETE FROM person WHERE id=?";
        Object[] args =new Object[] {person.getId()};
        jdbcTemplate.queryForObject(sql, new PersonRowMapper(),args);
    }

    @Override
    public Person updatePerson(Person person) {
        Object[] args = {person.getName(),person.getSurName(),person.getBirthDate() };
        jdbcTemplate.update("UPDATE SET name=?, sur_name=?, birth_date=? WHERE id=?",args);
        return person;
    }
}
