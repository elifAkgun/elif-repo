package code.elif.mains;

import code.elif.model.withAnnotation.promotion.TradeFair;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiredAnotationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans-annotation-autowired.xml");

        TradeFair myFair =  (TradeFair) applicationContext.getBean("myFair");
        System.out.println(myFair.specialPromotionalPricing());

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
