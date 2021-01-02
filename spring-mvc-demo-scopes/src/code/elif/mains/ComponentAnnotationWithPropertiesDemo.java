package code.elif.mains;

import code.elif.model.withAnnotation.OrganizationWithValues;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentAnnotationWithPropertiesDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-annotation-component.xml");

        OrganizationWithValues organization = (OrganizationWithValues) applicationContext.getBean("myOrgWithValue");

        System.out.println(organization);

        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
