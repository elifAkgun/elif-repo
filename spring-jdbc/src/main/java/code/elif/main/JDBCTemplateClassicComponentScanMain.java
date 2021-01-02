package code.elif.main;

import code.elif.dao.OrganizationDao;
import code.elif.model.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JDBCTemplateClassicComponentScanMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-cp-component-scan.xml");
        OrganizationDao orgDao = (OrganizationDao) applicationContext.getBean("orgDaoComp");

        List<Organization> allOrganisations = orgDao.getAllOrganisations();

        for (Organization org : allOrganisations ) {
            System.out.println(org);
        }

        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
