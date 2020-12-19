package code.elif.mains;

import code.elif.model.forXml.OrganizationWithDataNoConst;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PNamespaceDemo2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-namespace-p.xml");

        OrganizationWithDataNoConst organization = (OrganizationWithDataNoConst) applicationContext.getBean("myOrganizationWithDataNoConst");

        System.out.println(organization);

        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
