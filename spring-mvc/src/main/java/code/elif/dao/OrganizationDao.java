package code.elif.dao;

import code.elif.model.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {

    public void setDataSource(DataSource ds);

    public List<Organization> getAllOrganisations();

    public Boolean createOrganization(Organization organization);

    public Organization getOrganization(Integer id);

    public void deleteOrganization(Organization organization);

    public Organization updateOrganization(Organization organization);

    public void cleanUp();
}
