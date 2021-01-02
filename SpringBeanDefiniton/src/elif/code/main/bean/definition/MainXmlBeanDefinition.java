package elif.code.main.bean.definition;

import elif.code.model.simple.definition.SampleBeanWithConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import elif.code.model.simple.definition.SampleBeanWithSetter;

public class MainXmlBeanDefinition {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("app-context-bean.xml");

        SampleBeanWithSetter s = (SampleBeanWithSetter) app.getBean("mySampleBeanWithSetter");

        System.out.println(s);

        SampleBeanWithConstructor s2 = (SampleBeanWithConstructor) app.getBean("mySampleBeanWithConstructor");

        System.out.println(s2);
    }
}
