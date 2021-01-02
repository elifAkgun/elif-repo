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

    public Integer createOrganization(Organization organization) {
        return null;
    }

    public Organization getOrganization(Integer id) {
        return null;
    }

    public Boolean deleteOrganization(Organization organization) {
        return null;
    }

    public Organization updateOrganization(Organization organization) {
        return null;
    }

    public void cleanUp() {

    }
}
