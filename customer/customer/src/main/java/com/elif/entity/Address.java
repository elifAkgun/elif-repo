 package com.elif.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable 
public class Address {
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "zipCode")
	private String zipCode;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "country")
	private String country;


}
