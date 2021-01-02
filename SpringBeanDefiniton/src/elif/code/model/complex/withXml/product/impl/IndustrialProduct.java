package elif.code.model.complex.withXml.product.impl;

import elif.code.model.complex.withXml.product.GenericProduct;
import org.springframework.stereotype.Component;

import java.util.Random;


public class IndustrialProduct extends GenericProduct {

    @Override
    public int calculatePrice() {
        Random random = new Random();
        int price = random.nextInt(priceRandomizer);
        return price;
    }

}
