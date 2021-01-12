package code.elif.service.impl;

import code.elif.dao.impl.OrganizationDaoImpl;
import code.elif.model.Organization;
import code.elif.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OrganizationServiceImpl")
public class OrganizationServiceImpl implements OrganizationService {

    OrganizationDaoImpl organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDaoImpl organizationDao){
        this.organizationDao = organizationDao;
    }

    @Override
    public List<Organization> getAllOrganisations() {
        return organizationDao.getAllOrganisations();
    }

    @Override
    public Boolean createOrganization(Organization organization) {
        return organizationDao.createOrganization(organization);
    }

    @Override
    public Organization getOrganization(Integer id) {
        return organizationDao.getOrganization(id);
    }

    @Override
    public void deleteOrganization(Organization organization) {
        organizationDao.deleteOrganization(organization);
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationDao.updateOrganization(organization);
    }
}
