package elif.code.model.complex.withXml.promotion.setter;

import org.springframework.beans.factory.annotation.Autowired;

import elif.code.model.complex.withXml.product.impl.ConsumerProduct;
import elif.code.model.complex.withXml.product.impl.IndustrialProduct;

public class TradeFairSetterBasedInjection {

    private IndustrialProduct industrialProduct;

    private ConsumerProduct consumerProduct;

    public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
        return consumerProduct.calculatePrice();
    }

    public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
        return industrialProduct.calculatePrice();
    }

    @Autowired
    public void setConsumerProduct(ConsumerProduct consumerProduct) {
        this.consumerProduct = consumerProduct;
    }

    @Autowired
    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
        this.industrialProduct = industrialProduct;
    }

    public String specialPromotionalPricing() {
        String priceInfo = "Industrial Product is priced at $" + declareIndustrialProductPrice(industrialProduct)
                + " and " + "Consumer Product is priced at $" + declareConsumerProductPrice(consumerProduct);
        return priceInfo;
    }

}
