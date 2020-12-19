package code.elif.model.withAnnotation.promotion;


import code.elif.model.withAnnotation.ConsumerProduct;
import code.elif.model.withAnnotation.IndustrialProduct;
import org.springframework.beans.factory.annotation.Autowired;


public class TradeFairSetterBasedInjection {


	private IndustrialProduct industrialProduct;

	private ConsumerProduct consumerProduct;

	@Autowired
	public void setIndustrialProduct(IndustrialProduct industrialProduct) {
		this.industrialProduct = industrialProduct;
	}

	@Autowired
	public void setConsumerProduct(ConsumerProduct consumerProduct) {
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
