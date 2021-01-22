package code.elif.dao.impl;

import code.elif.dao.PersonDao;
import code.elif.dao.impl.rowMapper.PersonRowMapper;
import code.elif.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("personDaoComp")
public class PersonDaoImpl implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate= new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query("SELECT * FROM person", new PersonRowMapper());
    }

    @Override
    public Boolean createPerson(Person person) {
        Object[] args = {person.getName(),person.getSurName(),person.getBirthDate() };
        return  jdbcTemplate.update("INSERT INTO person (name, sur_name, birth_date) VALUES (?,?,?)",args)==1;
    }

    @Override
    public Person getPerson(Integer id) {
        String sql = "SELECT * FROM person WHERE id=?";
        Object[] args =new Object[] {id};
        Person person = jdbcTemplate.queryForObject(sql, new PersonRowMapper(),args);
        return person;
    }

    public void deletePerson(Integer id) {
        String sql = "DELETE FROM person WHERE id=?";
        Object[] args =new Object[] {id};
        jdbcTemplate.update(sql,args);
    }

    @Override
    public Person updatePerson(Person person) {
        Object[] args = {person.getName(),person.getSurName(),person.getBirthDate() };
        jdbcTemplate.update("UPDATE SET name=?, sur_name=?, birth_date=? WHERE id=?",args);
        return person;
    }

    @Override
    public List<Person> searchPersons(String theSearchName) {
        String sql = "SELECT * FROM person where name like :name";
        Map<String,Object> params = new HashMap<>();
        params.put("name", theSearchName+"%");
        return namedParameterJdbcTemplate.query(sql,params,new PersonRowMapper());
    }
}
