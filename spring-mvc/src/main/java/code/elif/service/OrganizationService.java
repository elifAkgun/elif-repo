package code.elif.service;

import code.elif.model.Organization;

import java.util.List;

public interface OrganizationService {

    public List<Organization> getAllOrganisations();

    public Boolean createOrganization(Organization organization);

    public Organization getOrganization(Integer id);

    public void deleteOrganization(Organization organization);

    public Organization updateOrganization(Organization organization);

}
