package code.elif.mains;

import code.elif.model.forXml.OrganizationWithData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CNamespaceDemo2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-namespace-c.xml");

        OrganizationWithData organization = (OrganizationWithData) applicationContext.getBean("myOrgWithData");

        System.out.println(organization);

        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
