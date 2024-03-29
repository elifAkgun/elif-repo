package elif.code.model.complex.withAnnotation.product.impl;

import java.util.Random;

import elif.code.model.complex.withAnnotation.product.GenericProduct;
import org.springframework.stereotype.Component;

@Component
public class IndustrialProduct extends GenericProduct {

    @Override
    public int calculatePrice() {
        Random random = new Random();
        int price = random.nextInt(priceRandomizer)*5;
        return price;
    }

}
