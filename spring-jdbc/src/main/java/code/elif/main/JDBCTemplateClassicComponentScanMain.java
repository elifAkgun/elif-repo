package code.elif.main;

import code.elif.dao.OrganizationDao;
import code.elif.model.Organization;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JDBCTemplateClassicComponentScanMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp-component-scan.xml");
        OrganizationDao orgDao = (OrganizationDao) applicationContext.getBean("orgDaoComp");


        createDataForOrganization(orgDao);

        printOrganizations(orgDao.getAllOrganisations());

        Organization updatedOrg =orgDao.getOrganization(1);
        updatedOrg.setCompanyName("Elif Company of Product");
        orgDao.updateOrganization(updatedOrg);

        printOrganizations(orgDao.getAllOrganisations());

        orgDao.deleteOrganization(orgDao.getOrganization(3));

        printOrganizations(orgDao.getAllOrganisations());

        orgDao.cleanUp();

       applicationContext.close();
    }

    private static void createDataForOrganization(OrganizationDao orgDao) {
        orgDao.createOrganization(new Organization("Elif Company",1989,
                "34",1,"Company Of Code.Elif is the best choice!"));

        orgDao.createOrganization(new Organization("Mirkaram Cats Ltd",2018,
                "34",1,"Meow!"));

        orgDao.createOrganization(new Organization("Aslı Tattoo",1997,
                "34",1,"Tattoo!"));
    }

    private static void printOrganizations(List<Organization> allOrganisations) {

        System.out.println("------------------Organizations-----------------------");

        for (Organization org : allOrganisations ) {
            System.out.println(org);
        }
    }
}
