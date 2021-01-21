package code.elif.dao.impl;

import code.elif.dao.OrganizationDao;
import code.elif.dao.impl.rowMapper.OrganizationRowMapper;
import code.elif.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class OrganizationDaoImplNamedParameterTemplate implements OrganizationDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Organization> getAllOrganisations() {
        String sql = "SELECT * FROM organization";
        List<Organization> organizationList = namedParameterJdbcTemplate.query(sql, new OrganizationRowMapper());
        return organizationList;
    }

    public Boolean createOrganization(Organization organization) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
                "VALUES(:companyName, :yearOfIncorporation, :postalCode ,:employeeCount, :slogan)";
        return namedParameterJdbcTemplate.update(sqlQuery, parameterSource) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sql = "SELECT * FROM organization WHERE id=:ID";
        Organization organization = namedParameterJdbcTemplate.queryForObject(sql,
                new MapSqlParameterSource("ID",id), new OrganizationRowMapper());
        return organization;
    }

    public void deleteOrganization(Organization organization) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sql = "delete from organization where id=:id";
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    public Organization updateOrganization(Organization organization) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(organization);
        String sql = "UPDATE organization set company_name=:companyName, year_of_incorporation=:yearOfIncorporation," +
               " postal_code=:postalCode, employee_count=:employeeCount, slogan=:slogan where id =:id";
        namedParameterJdbcTemplate.update(sql, parameterSource);
        return organization;
    }

    public void cleanUp() {
        String sqlQuery = "TRUNCATE TABLE organization ";
        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);
    }
}
