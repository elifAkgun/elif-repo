package elif.code.config;

import elif.code.model.complex.withAnnotation.product.impl.IndustrialProduct;
import elif.code.model.complex.withAnnotation.promotion.constructor.TradeFairConstructorBasedInjection;
import elif.code.model.complex.withAnnotation.product.impl.ConsumerProduct;
import elif.code.model.complex.withXml.promotion.setter.TradeFairSetterBasedInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigComplex {

    public ConsumerProduct myConsumerProduct() {
        return new ConsumerProduct();
    }

    public IndustrialProduct myIndustrialProduct() {
        return new IndustrialProduct();
    }

    @Bean(name = "myFairConstructorBased")
    public TradeFairConstructorBasedInjection myTradeFairConstructorBasedInjection() {
        return new TradeFairConstructorBasedInjection(myIndustrialProduct(), myConsumerProduct());
    }
}
