package elif.code.main.bean.definition;

import elif.code.config.JavaConfigComponentScan;
import elif.code.config.JavaConfigSimple;
import elif.code.config.JavaConfigWithProperty;
import elif.code.model.simple.OrganizationWithValues;
import elif.code.model.simple.definition.SampleBeanJavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfigComponentScan {

    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfigWithProperty.class);

        OrganizationWithValues o = (OrganizationWithValues) app.getBean("myOrgWithValue");

        System.out.println(o);
        System.out.println(o.getMySlogan());

    }
}
