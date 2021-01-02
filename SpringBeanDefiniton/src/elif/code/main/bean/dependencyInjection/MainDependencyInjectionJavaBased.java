package elif.code.main.bean.dependencyInjection;


import elif.code.config.JavaConfigComplex;
import elif.code.model.complex.withAnnotation.promotion.constructor.TradeFairConstructorBasedInjection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDependencyInjectionJavaBased {

    public static void main(String[] args) {

        ApplicationContext app = new AnnotationConfigApplicationContext(JavaConfigComplex.class);

        TradeFairConstructorBasedInjection tradeFairConstructorBasedInjection = (TradeFairConstructorBasedInjection) app
                .getBean("myFairConstructorBased");

        System.out.println(tradeFairConstructorBasedInjection.specialPromotionalPricing());

    }
}
