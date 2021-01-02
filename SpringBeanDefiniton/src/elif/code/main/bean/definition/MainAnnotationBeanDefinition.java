package elif.code.main.bean.definition;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import elif.code.model.simple.definition.SampleBeanCompAnnotation;

public class MainAnnotationBeanDefinition {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("asd.xml");

        SampleBeanCompAnnotation s = (SampleBeanCompAnnotation) app.getBean("mySampleBeanCompAnnotation");

        System.out.println(s);
    }
}
