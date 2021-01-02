package elif.code.model.complex.withAnnotation.product.impl;

import java.util.Random;

import elif.code.model.complex.withAnnotation.product.GenericProduct;
import org.springframework.stereotype.Component;

@Component
public class ConsumerProduct extends GenericProduct {

    @Override
    public int calculatePrice() {
        Random random = new Random();
        int price = random.nextInt(priceRandomizer);
        return price;
    }

}
