package elif.code.main.bean.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import elif.code.model.complex.withAnnotation.promotion.constructor.TradeFairConstructorBasedInjection;
import elif.code.model.complex.withAnnotation.promotion.setter.TradeFairSetterBasedInjection;

public class MainDependencyInjectionAnnotationBased {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("app-context-annotation-complex.xml");

        TradeFairConstructorBasedInjection tradeFairConstructorBasedInjection = (TradeFairConstructorBasedInjection) app
                .getBean("myFairConstructorBased");

        System.out.println(tradeFairConstructorBasedInjection.specialPromotionalPricing());

        TradeFairSetterBasedInjection tradeFairSetterBasedInjection = (TradeFairSetterBasedInjection) app
                .getBean("myFairSetterBased");

        System.out.println(tradeFairSetterBasedInjection.specialPromotionalPricing());
    }
}
