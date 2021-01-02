package elif.code.main.bean.definition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import elif.code.config.JavaConfigSimple;
import elif.code.model.simple.definition.SampleBeanJavaConfig;

public class MainJavaConfigBeanDefinition {

    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfigSimple.class);

        SampleBeanJavaConfig s = (SampleBeanJavaConfig) app.getBean("mySampleBean");

        System.out.println(s);
    }
}
