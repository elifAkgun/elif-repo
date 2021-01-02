package elif.code.main.bean.dependencyInjection;


import elif.code.model.complex.withXml.promotion.constructor.TradeFairConstructorBasedInjection;
import elif.code.model.complex.withXml.promotion.setter.TradeFairSetterBasedInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDependencyInjectionXMLBased {

    public static void main(String[] args) {

        ApplicationContext app = new ClassPathXmlApplicationContext("app-context-di.xml");

        TradeFairConstructorBasedInjection tradeFairConstructorBasedInjection = (TradeFairConstructorBasedInjection) app
                .getBean("myFairConstructor");

        System.out.println(tradeFairConstructorBasedInjection.specialPromotionalPricing());

        TradeFairSetterBasedInjection tradeFairSetterBasedInjection = (TradeFairSetterBasedInjection) app
                .getBean("myFairSetter");

        System.out.println(tradeFairSetterBasedInjection.specialPromotionalPricing());



    }
}
