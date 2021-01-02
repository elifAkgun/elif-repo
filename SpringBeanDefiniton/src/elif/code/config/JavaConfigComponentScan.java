package elif.code.config;

import elif.code.model.complex.withAnnotation.product.impl.ConsumerProduct;
import elif.code.model.complex.withAnnotation.product.impl.IndustrialProduct;
import elif.code.model.complex.withAnnotation.promotion.constructor.TradeFairConstructorBasedInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"elif.code.model.complex.withAnnotation"})
public class JavaConfigComponentScan {

}
