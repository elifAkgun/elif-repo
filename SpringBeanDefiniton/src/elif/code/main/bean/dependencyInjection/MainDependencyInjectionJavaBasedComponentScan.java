package elif.code.main.bean.dependencyInjection;


import elif.code.config.JavaConfigComponentScan;
import elif.code.model.complex.withAnnotation.promotion.constructor.TradeFairConstructorBasedInjection;
import elif.code.model.complex.withXml.promotion.setter.TradeFairSetterBasedInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDependencyInjectionJavaBasedComponentScan {

    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfigComponentScan.class);

        TradeFairConstructorBasedInjection tradeFairConstructorBasedInjection = (TradeFairConstructorBasedInjection) app
                .getBean("myFairConstructorBased");

        System.out.println(tradeFairConstructorBasedInjection.specialPromotionalPricing());

        TradeFairSetterBasedInjection tradeFairSetterBasedInjection = (TradeFairSetterBasedInjection) app
                .getBean("myFairSetterBased");

        System.out.println(tradeFairSetterBasedInjection.specialPromotionalPricing());


    }
}
