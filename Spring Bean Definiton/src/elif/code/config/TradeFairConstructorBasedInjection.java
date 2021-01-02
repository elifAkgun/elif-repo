package elif.code.config;

import elif.code.model.complex.withAnnotation.product.impl.ConsumerProduct;
import elif.code.model.complex.withAnnotation.product.impl.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myFairConstructorBased")
public class TradeFairConstructorBasedInjection {

    private IndustrialProduct industrialProduct;

    private ConsumerProduct consumerProduct;

    @Autowired
    public TradeFairConstructorBasedInjection(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
        this.industrialProduct = industrialProduct;
        this.consumerProduct = consumerProduct;
    }

    public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
        return consumerProduct.calculatePrice();
    }

    public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
        return industrialProduct.calculatePrice();
    }

    public String specialPromotionalPricing() {
        String priceInfo = "Industrial Product is priced at $" + declareIndustrialProductPrice(industrialProduct)
                + " and " + "Consumer Product is priced at $" + declareConsumerProductPrice(consumerProduct);
        return priceInfo;
    }

}
