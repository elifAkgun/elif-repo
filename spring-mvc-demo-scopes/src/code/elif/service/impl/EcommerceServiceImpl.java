package code.elif.service.impl;

import java.util.Random;

import code.elif.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService  {

public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, "+ companyName +
				" provides an outstanding Ecommerce platform." +
				"\nThe annual revenue exceeds "+ random.nextInt(revenue) + " dollars.";
		return service;
	}

	public void postConstruct() {
		System.out.println("EcommerceServiceImpl : postConstruct  method called.");
	}

	public void preDestroy() {
		System.out.println("EcommerceServiceImpl : preDestroy method called.");
	}
}
