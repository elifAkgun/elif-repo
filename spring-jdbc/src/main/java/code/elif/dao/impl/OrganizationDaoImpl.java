package code.elif.dao.impl;

import code.elif.dao.OrganizationDao;
import code.elif.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component("orgDaoComp")
public class OrganizationDaoImpl implements OrganizationDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate= new JdbcTemplate(dataSource);
    }

    public List<Organization> getAllOrganisations() {
        String sql = "SELECT * FROM organization";
        List<Organization> organizationList = jdbcTemplate.query(sql, new OrganizationRowMapper());
        return organizationList;
    }

    public Boolean createOrganization(Organization organization) {
        String sqlQuery = "INSERT INTO organization (company_name, year_of_incorporation, postal_code, employee_count, slogan) " +
                "VALUES(?, ?, ?, ?, ?)";
        Object[] args = new Object[] { organization.getCompanyName(), organization.getYearOfIncorporation(), organization.getPostalCode(),
                organization.getEmployeeCount(), organization.getSlogan()};
        return jdbcTemplate.update(sqlQuery, args) == 1;
    }

    public Organization getOrganization(Integer id) {
        String sql = "SELECT * FROM organization WHERE id=?";
        Object[] args =new Object[] {id};
        Organization organization = jdbcTemplate.queryForObject(sql, new OrganizationRowMapper(),args);
        return organization;
    }

    public void deleteOrganization(Organization organization) {
        String sql = "delete from organization where id = ?";
        jdbcTemplate.update(sql, organization.getId());
    }

    public Organization updateOrganization(Organization organization) {
       String sql = "UPDATE organization set company_name=?, year_of_incorporation=?," +
               " postal_code=?, employee_count=?, slogan=? where id =?";
        Object[] args = new Object[] { organization.getCompanyName(), organization.getYearOfIncorporation(), organization.getPostalCode(),
                organization.getEmployeeCount(), organization.getSlogan(),organization.getId()};
        jdbcTemplate.update(sql, args);
        return organization;
    }

    public void cleanUp() {
        String sqlQuery = "TRUNCATE TABLE organization ";
        jdbcTemplate.execute(sqlQuery);
    }
}
