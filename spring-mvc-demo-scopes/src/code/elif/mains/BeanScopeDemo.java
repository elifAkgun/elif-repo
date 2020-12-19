package code.elif.mains;

import code.elif.model.forXml.Organization;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

    public static void main(String[] args) {
        // create the application context (container)
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cp.xml");

        // create the bean
        Organization org = (Organization) ctx.getBean("myOrg");
        Organization org2 = (Organization) ctx.getBean("myOrg");
        org2.setPostalCode("98989");

        // invoke the company slogan via the bean

        // Print Organization details
        System.out.println(org);
        System.out.println(org2);
        if (org == org2) {

            System.out.println("Singleton scope test: org and org2 point to the same instance");
        } else {

            System.out.println("Both org and org2 are separate instances");
        }

        // close the application context (container)
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
