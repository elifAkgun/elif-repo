package com.elif.jpa;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
@AttributeOverride(name="id", column = @Column(name = "customer_id"))
public class Customer extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Embedded
	private Address address;
	
	@Column(name = "activateDate")
	private LocalDate activateDate;
	
	@ElementCollection
	@OrderColumn(name = "phone_order")
    @CollectionTable(name = "customer_phone", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "phone")
	private List<String> phoneNumbers;
	
	@OneToMany(mappedBy = "customer")
	private List<Payment> payments;
	
	@ManyToMany(mappedBy = "customers")
	private List<Bank> banks;

}
