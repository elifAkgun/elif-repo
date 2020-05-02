 package com.elif.jpa;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable 
public class Address {
	private String street;
	private String zipCode;
	private String city;
	private String country;


}
