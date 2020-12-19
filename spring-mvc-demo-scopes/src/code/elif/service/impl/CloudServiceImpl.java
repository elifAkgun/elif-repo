package code.elif.service.impl;

import java.util.Random;

import code.elif.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs an Organization, " + companyName +
				" offers world class Cloud computing infrastructure."+
				"\nThe annual income exceeds "+ random.nextInt(revenue) + " dollars.";
		return service;
	}
	public void postConstruct() {
		System.out.println("CloudServiceImpl : postConstruct  method called.");
	}

	public void preDestroy() {
		System.out.println("CloudServiceImpl : preDestroy method called.");
	}
}