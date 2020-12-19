package code.elif.model.withAnnotation.promotion;


import code.elif.model.withAnnotation.ConsumerProduct;
import code.elif.model.withAnnotation.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myFair")
public class TradeFair {


	private IndustrialProduct industrialProduct;

	private ConsumerProduct consumerProduct;

	@Autowired
	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
		this.industrialProduct = industrialProduct;
		this.consumerProduct = consumerProduct;
	}

	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}
	
	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}
	
	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product is priced at $"+ declareIndustrialProductPrice(industrialProduct)
				+ " and "
				+ "Consumer Product is priced at $"+ declareConsumerProductPrice(consumerProduct);
		return priceInfo;
	}

}
