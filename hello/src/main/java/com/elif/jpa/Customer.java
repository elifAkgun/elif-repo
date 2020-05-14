package com.elif.jpa;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import com.elif.util.LocalDateDeserializer;
import com.elif.util.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate activateDate;
	
	@ElementCollection
	@OrderColumn(name = "phone_order")
    @CollectionTable(name = "customer_phone", joinColumns = @JoinColumn(name = "customer_id"))
	@Column(name = "phone")
	private List<String> phoneNumbers;
	
	@OneToMany(mappedBy = "customer")
	private List<Payment> payments;

	  
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "customer_bank",
    joinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "customer_id"),
    inverseJoinColumns = @JoinColumn(name = "bank_id", referencedColumnName = "bank_id"))
	private Set<Bank> banks= new HashSet<>();;

}
